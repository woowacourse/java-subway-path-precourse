package subway.view;

import subway.domain.MainMenuType;
import subway.domain.RouteCheckType;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.Scanner;

public class InputView {
    private static final String MAIN_SCREEN = "## 메인 화면\n1. 경로 조회\nQ. 종료";
    private static final String INPUT_MESSAGE = "## 원하는 기능을 선택하세요.";
    private static final String ROUTE_CHECK_SCREEN = "## 경로 기준\n1. 최단 거리\n2. 최소 시간\nB. 돌아가기";
    private static final String INPUT_START_STATION_MESSAGE = "## 출발역을 입력하세요.";


    private InputView() {
    }

    public static MainMenuType inputMainMenu(Scanner scanner) {
        try {
            System.out.println(MAIN_SCREEN);
            System.out.println(INPUT_MESSAGE);
            return MainMenuType.of(scanner.nextLine());
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputMainMenu(scanner);
        }
    }

    public static RouteCheckType inputRouteCheckType(Scanner scanner) {
        try {
            System.out.println(ROUTE_CHECK_SCREEN);
            System.out.println(INPUT_MESSAGE);
            return RouteCheckType.of(scanner.nextLine());
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputRouteCheckType(scanner);
        }
    }

    public static Station inputStartStation(Scanner scanner) {
        System.out.println(INPUT_START_STATION_MESSAGE);
        return StationRepository.findByStationName(scanner.nextLine());
    }
}
