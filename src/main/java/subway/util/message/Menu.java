package subway.util.message;

import subway.util.constants.EnumUtil;

public enum Menu implements EnumUtil<String, String> {
    SELECT_ROUTINE("1", "1. 경로 조회"),
    EXIT("Q", "Q. 종료\n"),
    SHORTEST_DISTANCE("1", "1. 최단 거리"),
    SHORTEST_TIME("2", "2. 최소 시간"),
    BACK("B", "B. 돌아가기\n");

    private String code;
    private String message;
    Menu(String code, String message){
        this.code = code;
        this.message = message;
    }

    @Override
    public String getKey() {
        return code;
    }

    @Override
    public String getValue() {
        return message;
    }
}
