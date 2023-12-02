package subway.util.message;

import subway.util.constants.EnumUtil;

public enum InputMessage implements EnumUtil<String, String> {
    MAIN_SCREEN("## 메인 화면"),
    SELECT_WANTED("## 원하는 기능을 선택하세요."),
    ROUTINE("\n## 경로 기준"),
    GET_START_STATION("\n## 출발역을 입력하세요."),
    GET_END_STARTION("\n## 도착역을 입력하세요."),
    SELECT_RESULT("\n## 조회 결과");

    private String message;
    InputMessage(String message){
        this.message = message;
    }

    @Override
    public String getKey() {
        return name();
    }

    @Override
    public String getValue() {
        return message;
    }
}
