package subway.message;

public enum RouteMessage implements Message {
    SELECT_START_STATION("출발역을 입력하세요."),
    SELECT_END_STATION("도착역을 입력하세요."),

    ERROR_STATION_NAME("역 이름이 올바르지 않습니다."),
    ERROR_STATION_DUPLICATE_NAME("출발역과 도착역이 동일합니다."),

    RESULT("조회 결과"),
    LINE("---"),
    TOTAL_DISTANCE("총 거리: "),
    TOTAL_TIME("총 소요 시간: "),
    ;

    private String message;

    RouteMessage(String content) {
        this.message = content;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

