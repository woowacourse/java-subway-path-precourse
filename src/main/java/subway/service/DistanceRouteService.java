package subway.service;

import subway.domain.DistanceMap;
import subway.domain.Station;

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
}
