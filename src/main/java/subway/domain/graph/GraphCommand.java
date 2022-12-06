package subway.domain.graph;

import java.util.Arrays;

public enum GraphCommand {
    SHORTEST_DISTANCE("1"),
    SHORTEST_TIME("2"),
    BACK("B");

    private final String button;

    GraphCommand(String button) {
        this.button = button;
    }

    public static GraphCommand convertToCommand(String button) {
        return Arrays.stream(values())
                .filter(value -> value.button.equals(button))
                .findAny()
                .orElse(null);
    }
}
