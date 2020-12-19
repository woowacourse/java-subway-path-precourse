package subway.pathfind;

import java.util.ArrayList;
import java.util.List;
import subway.domain.DistanceAndTimeBetweenStationsRepository;
import subway.domain.Station;
import subway.pathfind.validator.PathFindValidator;

public class MinimumTimePathFinder {
    private static List<Station> minimumTimePath = new ArrayList<>();
    private static int minimumTime = Integer.MAX_VALUE;
    private static int totalDistance = Integer.MAX_VALUE;
    private static final int INITIAL_TIME = 0;
    private static final int INITIAL_DISTANCE = 0;
    private static final List<Station> visitedStations = new ArrayList<>();


    public static void find(Station startStation, Station endStation) {
        findWay(startStation, endStation, INITIAL_TIME, INITIAL_DISTANCE, new ArrayList<>());
        PathFindValidator.validatePathExists(minimumTimePath);
        ResultPrinter.resultPrinter(minimumTimePath, totalDistance, minimumTime);
        minimumTimePath.clear();
        visitedStations.clear();
        minimumTime = Integer.MAX_VALUE;
        totalDistance = Integer.MAX_VALUE;
    }

    private static void findWay(Station currentStation, Station endStation, int currentTime,
        int currentDistance, List<Station> currentPath) {
        visitedStations.add(currentStation);
        currentPath.add(currentStation);
        if (currentStation.getName().equals(endStation.getName())) {
            if (resetPathAndTimeAndDistanceValue(currentTime, currentPath, currentDistance)) {
                currentPath.remove(currentStation);
                visitedStations.remove(currentStation);
                return;
            }
        }
        List<Station> nextConnectedStations = currentStation.getConnectedStations();
        findNextPath(currentStation, endStation, currentTime, currentDistance, currentPath,
            nextConnectedStations);
    }

    private static void findNextPath(Station currentStation, Station endStation, int currentTime,
        int currentDistance, List<Station> currentPath, List<Station> nextConnectedStations) {
        for (Station nextConnectedStation : nextConnectedStations) {
            if (visitedStations.contains(nextConnectedStation)) {
                continue;
            }
            TimeAndDistance timeAndDistance = DistanceAndTimeBetweenStationsRepository
                .getBetweenTimeAndDistance(currentStation, nextConnectedStation);
            findWay(nextConnectedStation, endStation, currentTime + timeAndDistance.getTime(),
                currentDistance + timeAndDistance.getDistance(), currentPath);
        }
        currentPath.remove(currentStation);
        visitedStations.remove(currentStation);
    }

    private static boolean resetPathAndTimeAndDistanceValue(int currentTime,
        List<Station> currentPath, int currentDistance) {
        if (minimumTime > currentTime) {
            minimumTime = currentTime;
            minimumTimePath.clear();
            minimumTimePath.addAll(currentPath);
            totalDistance = currentDistance;
            return true;
        }
        return false;
    }


}
