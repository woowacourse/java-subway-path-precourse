package subway.console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.jgrapht.GraphPath;
import subway.domain.PathFinder;
import subway.domain.Station;

public enum PathCriteriaMenu {
    SHORTEST_DISTANCE("최단 거리", "1") {
        @Override
        void execute() {
            ArrayList<Station> stations = Input.getStationsToFindPath();
            GraphPath shortestPath = PathFinder.findPathBetweenStationsByShortestDistance(stations.get(0), stations.get(1));
            List<Station> stationsList = shortestPath.getVertexList();
            double totalWeight = shortestPath.getWeight();
            System.out.println(DISPLAY_RESULT);
            System.out.println(INFO + DELIMITER);
            System.out.println(TOTAL_DISTANCE + totalWeight + KM);
            System.out.println(INFO + DELIMITER);
            for (Station station : stationsList) {
                System.out.println(INFO + station.getName());
            }
        }
    },
    MINIMUM_TIME("최소 시간", "2") {
        @Override
        void execute() {
            ArrayList<Station> stations = Input.getStationsToFindPath();
            GraphPath shortestPath = PathFinder.findPathBetweenStationsByMinimumTime(stations.get(0), stations.get(1));
            List<Station> stationsList = shortestPath.getVertexList();
            double totalWeight = shortestPath.getWeight();
            System.out.println(DISPLAY_RESULT);
            System.out.println(INFO + DELIMITER);
            System.out.println(TOTAL_TIME + totalWeight + MINUTE);
            System.out.println(INFO + DELIMITER);
            for (Station station : stationsList) {
                System.out.println(INFO + station.getName());
            }
        }
    },
    BACK("돌아가기", "B") {
        @Override
        void execute() { }
    };

    private final String name;
    private final String symbol;
    private static final String DISPLAY_RESULT = "## 조회 결과";
    private static final String INFO = "[INFO] ";
    private static final String KM = "km";
    private static final String TOTAL_DISTANCE = "총 거리: ";
    private static final String TOTAL_TIME = "총 소요시간: ";
    private static final String DELIMITER = "---";
    private static final String MINUTE = "분";

    PathCriteriaMenu(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    abstract void execute();

    public static void executeMenuByInput(String input) {
        try {
            Arrays.stream(PathCriteriaMenu.values())
                .filter(menu -> menu.getSymbol().equals(input))
                .findAny()
                .get()
                .execute();
        } catch (Exception e) {
            throw new IllegalMenuInputException();
        }

    }
}
