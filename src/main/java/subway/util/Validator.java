package subway.util;

import subway.menu.MainMenu;

import java.util.Arrays;

public class Validator {
    private final String OPTION_NOT_FOUND_WARN = "[ERROR] 선택지 안의 기능을 선택하셔야 합니다.\n";

    protected void validateMainMenuOption(String option) {
        boolean result = Arrays.stream(MainMenu.values())
                .map(MainMenu::getOption)
                .anyMatch(menuOption -> menuOption.equals(option));
        if (!result) {
            throw new IllegalArgumentException(OPTION_NOT_FOUND_WARN);
        }
    }
}
