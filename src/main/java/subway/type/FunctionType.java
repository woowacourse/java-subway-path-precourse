package subway.type;

import java.util.Objects;

public enum FunctionType {
    SHORTEST_DISTANCE_ROUTE("1"),
    MINIMUM_TIME_ROUTE("2"),
    BACK("B");

    private final String functionLetter;

    private FunctionType(String functionLetter) {
        this.functionLetter = functionLetter;
    }

    public boolean matches(String functionLetter) {
        return Objects.equals(this.functionLetter, functionLetter);
    }
}
