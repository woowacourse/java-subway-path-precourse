package subway.console;

import java.util.ArrayList;
import java.util.Scanner;
import subway.domain.Station;
import subway.domain.StationRepository;

public class Input {
    private static final String MESSAGE_SELECT_MENU = "\n## 원하는 기능을 선택하세요.";
    private static final String ADD_START_STATION = "\n## 출발역을 입력하세요.";
    private static final String ADD_END_STATION = "\n## 도착역을 입력하세요.";
    static Scanner scanner;

    public Input(Scanner scanner) {
        this.scanner = scanner;
    }

    public static String getMainScreenInput() {
        System.out.println(MESSAGE_SELECT_MENU);
        return scanner.nextLine();
    }

    public static String getPathCriteriaScreenInput() {
        System.out.println(MESSAGE_SELECT_MENU);
        return scanner.nextLine();
    }

    public static ArrayList<Station> getStationsToFindPath() {
        ArrayList<Station> stations = new ArrayList<>();
        System.out.println(ADD_START_STATION);
        stations.add(StationRepository.getStation(scanner.nextLine()));
        System.out.println(ADD_END_STATION);
        stations.add(StationRepository.getStation(scanner.nextLine()));
        return stations;
    }
}
