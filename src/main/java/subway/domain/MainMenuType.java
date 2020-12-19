package subway.domain;

import java.util.Arrays;

public enum MainMenuType {
    PATH_CHECK("1"),
    QUIT("Q");

    private String functionCode;

    MainMenuType(String functionCode) {
        this.functionCode = functionCode;
    }

    public static MainMenuType of(String inputCode) {
        return Arrays.stream(MainMenuType.values())
                .filter(functionType -> functionType.functionCode.equals(inputCode))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 잘못된 입력입니다. 다시 입력해주세요."));
    }
}
