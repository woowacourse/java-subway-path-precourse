package subway.domain.global;

import java.util.Arrays;

public enum SystemCommand {
    FIND_PATH("1"),
    QUIT("Q");

    private final String button;

    SystemCommand(String button) {
        this.button = button;
    }

    public static SystemCommand convertToCommand(String button) {
        return Arrays.stream(values())
                .filter(value -> value.button.equals(button))
                .findAny()
                .orElse(null);
    }
}
