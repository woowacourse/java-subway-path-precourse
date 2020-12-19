package subway.vo;

import java.util.Objects;

public enum FunctionType {
    SHORTEST_DISTANCE("1"),
    MINIMUM_TIME("2"),
    BACK("B");

    private final String functionNumber;

    FunctionType(String functionNumber) {
        this.functionNumber = functionNumber;
    }

    public boolean matches(String functionNumber) {
        return Objects.equals(this.functionNumber, functionNumber);
    }
}
