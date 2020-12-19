package subway.view;

import subway.exception.InvalidChoiceException;

import java.util.Arrays;

public enum StandardChoice {
    DISTANCE("1"),
    TIME("2"),
    BACK("B"),
    ;

    String value;

    StandardChoice(String value) {
        this.value = value;
    }

    public static StandardChoice of(String value) {
        return Arrays.stream(StandardChoice.values())
                .filter(choice -> choice.value.equals(value))
                .findAny()
                .orElseThrow(InvalidChoiceException::new);
    }
}
