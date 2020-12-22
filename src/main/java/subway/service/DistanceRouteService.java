package subway.service;

import subway.domain.DistanceMap;
import subway.domain.Section;
import subway.domain.Station;
import subway.repository.SectionRepository;
import subway.views.routeviews.RouteOutputView;

import java.util.List;
import java.util.Scanner;

public class DistanceRouteService implements RouteService {
    private static final DistanceRouteService distanceRouteService = new DistanceRouteService();

    private DistanceRouteService() {
    }

    public static DistanceRouteService getInstance() {
        return distanceRouteService;
    }

    @Override
    public void routingService(Scanner scanner) {
        try {
            Station startStation = inputStartStations(scanner);
            Station endStation = inputEndStation(scanner);
            isSameName(startStation, endStation);
            DistanceMap distanceMap = new DistanceMap();
            distanceMap.addStationVertex();
            distanceMap.addWeight();
            List<Station> stationList = distanceMap.getShortestDistanceRoute(distanceMap.getGraph(), startStation, endStation);
            calculateTotalDistanceAndTime(stationList);
        } catch (IllegalArgumentException e) {
            goToMenu(e, scanner);
        }
    }

    private void calculateTotalDistanceAndTime(List<Station> shortestRouteStationList) {
        int totalDistance = calculateTotalDistance(shortestRouteStationList);
        int totalTime = calculateTotalTime(shortestRouteStationList);
        RouteOutputView.printRoutedMapWithResources(shortestRouteStationList, totalDistance, totalTime);
    }

    private int calculateTotalDistance(List<Station> shortestRouteStationList) {
        int totalDistance = 0;
        for (int i = 0; i < shortestRouteStationList.size()-1 ; i++) {
            Section section = new Section(shortestRouteStationList.get(i), shortestRouteStationList.get(i + 1));
            totalDistance += SectionRepository.sections().get(section).getDistance().getDistance();
        }
        return totalDistance;
    }

    private int calculateTotalTime(List<Station> shortestRouteStationList) {
        int totalTime = 0;
        for (int i = 0; i < shortestRouteStationList.size()-1 ; i++) {
            Section section = new Section(shortestRouteStationList.get(i), shortestRouteStationList.get(i + 1));
            totalTime += SectionRepository.sections().get(section).getTime().getTime();
        }
        return totalTime;
    }
}
