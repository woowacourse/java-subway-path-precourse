package subway.view;

import subway.controller.SubwayController;
import subway.exception.InvalidChoiceException;

import java.util.Arrays;

public enum MainChoice {
    FIND("1"),
    EXIT("Q"),
    ;

    private final String value;

    MainChoice(String value) {
        this.value = value;
    }

    public static MainChoice of(String value) {
        return Arrays.stream(MainChoice.values())
                .filter(choice -> choice.value.equals(value))
                .findAny()
                .orElseThrow(InvalidChoiceException::new);
    }
}
