package view;

import subway.domain.MainMenuType;
import subway.domain.PathStandardType;
import subway.domain.StationRepository;

import java.util.Scanner;

public class InputView {
    private static final String SELECT_FUNCTION_MESSAGE = "## 원하는 기능을 선택하세요.";
    private static final String SELECT_FUNCTION_ERROR_MESSAGE = "[ERROR] 알 수 없는 기능입니다.";
    private static final String SELECT_DEPARTURE_STATION_MESSAGE = "## 출발역을 입력하세요.";

    private InputView() {
    }

    public static MainMenuType inputFunctionNumber(Scanner scanner) {
        System.out.println(SELECT_FUNCTION_MESSAGE);
        return readMenu(scanner);
    }

    private static MainMenuType readMenu(Scanner scanner) {
        try {
            return MainMenuType.of(scanner.nextLine());
        } catch (Exception e) {
            System.out.println(SELECT_FUNCTION_ERROR_MESSAGE);
            return inputFunctionNumber(scanner);
        }
    }

    public static PathStandardType inputPathStandardFunctionNumber(Scanner scanner) {
        System.out.println(SELECT_FUNCTION_MESSAGE);
        return readPathStandard(scanner);
    }

    private static PathStandardType readPathStandard(Scanner scanner) {
        try {
            return PathStandardType.of(scanner.nextLine());
        } catch (Exception e) {
            System.out.println(SELECT_FUNCTION_ERROR_MESSAGE);
            return inputPathStandardFunctionNumber(scanner);
        }
    }

    public static void inputDepartureStation(Scanner scanner) {
        System.out.println(SELECT_DEPARTURE_STATION_MESSAGE);
        String departureStation = scanner.nextLine();
        if (!StationRepository.isStationExist(departureStation)) {
            throw new IllegalArgumentException("[ERROR] 등록되어 있지 않은 역입니다.");
        }
    }
}
