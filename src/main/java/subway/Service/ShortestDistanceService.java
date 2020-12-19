package subway.Service;

import subway.domain.*;

import java.util.List;
import java.util.NoSuchElementException;

public class ShortestDistanceService {

    public void lookup(Station startStation, Station arriveStation) {
        try {
            List<LineStation> routeList = LineStationRepository.findLineWithStation(startStation, arriveStation);
            shortestRoute(routeList, startStation, arriveStation);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }

    private void shortestRoute(List<LineStation> routeList, Station startStation, Station arriveStation) {
        int totalDistance = Integer.MAX_VALUE;
        int lineDistance;
        String findLine = "";
        for (LineStation lineStation : routeList) {
            List<Section> sections = lineStation.getSectionInfos();
            lineDistance = 0;
            for (Section section : sections) {
                lineDistance += Integer.parseInt(section.getDistance());
            }
            if (lineDistance < totalDistance) {
                findLine = lineStation.getLine().getName();
                totalDistance = lineDistance;
            }
        }

        System.out.println("호선:" + findLine + "\n" + "총 길이: " +  totalDistance);
    }
}
