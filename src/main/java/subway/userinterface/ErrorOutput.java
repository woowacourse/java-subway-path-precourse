package subway.userinterface;

import subway.domain.MenuRepository;

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


}
