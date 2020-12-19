package subway.domain;

import java.util.Arrays;

public enum PathStandardType {
    SHORTEST_DISTANCE("1"),
    SHORTEST_TIME("2"),
    BACK("B");

    private String functionCode;

    PathStandardType(String functionCode) {
        this.functionCode = functionCode;
    }

    public static PathStandardType of(String inputCode) {
        return Arrays.stream(PathStandardType.values())
                .filter(functionType -> functionType.functionCode.equals(inputCode))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 잘못된 입력입니다. 다시 입력해주세요."));
    }
}
