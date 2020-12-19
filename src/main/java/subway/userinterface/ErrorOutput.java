package subway.userinterface;

import subway.domain.MenuRepository;
import subway.domain.StationRepository;

public class ErrorOutput {
    private static final String ERROR = "\n[ERROR] ";

    public static boolean returnStatus(boolean status) {
        if (status) {
            System.out.println(ERROR + "선택할 수 없는 기능입니다.");
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
            System.out.println(ERROR+"존재하지 않는 역 이름입니다.");
            return true;
        }
        return false;
    }

    public static boolean printSameStationNameError(String start, String end) {
        if (start.equals(end)) {
            System.out.println(ERROR +"출발역과 도착역이 동일합니다.");
            return true;
        }
        return false;
    }

    public static void printNotConnectedError() {
        System.out.println(ERROR+"출발역과 도착역이 서로 연결되어있지 않습니다.");
    }


}
