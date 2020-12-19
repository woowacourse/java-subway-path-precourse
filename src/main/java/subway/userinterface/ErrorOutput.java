package subway.userinterface;

import subway.domain.MenuRepository;
import subway.domain.StationRepository;

public class ErrorOutput {
    private static final String ERROR = "\n[ERROR] ";
    private static final String NOT_EXISTING_STATION = "존재하지 않는 역 이름입니다.";
    private static final String SAME_START_END_INPUT = "출발역과 도착역이 동일합니다.";
    private static final String START_END_NOT_CONNECTED = "출발역과 도착역이 서로 연결되어있지 않습니다.";
    private static final String INPUT_ERROR = "선택할 수 없는 기능입니다.";

    public static boolean returnStatus(boolean status) {
        if (status) {
            System.out.println(ERROR + INPUT_ERROR);
        }
        return status;
    }

    public static boolean isWrongMainMenuInput(String input) {
        boolean status = MenuRepository.mainMenuButtons.stream().noneMatch(button -> button.equals(input));
        return returnStatus(status);
    }

    public static boolean isWrongSearchMenuInput(String input) {
        boolean status = MenuRepository.searchMenuButtons.stream().noneMatch(button -> button.equals(input));
        return returnStatus(status);
    }

    public static boolean printWrongStationInput(String input) {
        if (!StationRepository.isStationPresent(input)) {
            System.out.println(ERROR + NOT_EXISTING_STATION);
            return true;
        }
        return false;
    }

    public static boolean printSameStationNameError(String start, String end) {
        if (start.equals(end)) {
            System.out.println(ERROR + SAME_START_END_INPUT);
            return true;
        }
        return false;
    }

    public static void printNotConnectedError() {
        System.out.println(ERROR + START_END_NOT_CONNECTED);
    }


}
