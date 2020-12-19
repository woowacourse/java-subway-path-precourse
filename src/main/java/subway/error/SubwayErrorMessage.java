package subway.error;

public enum SubwayErrorMessage {
    NOT_EXIST_STATION("노선에 등록되어 있지 않는 역입니다."),
    DUPLICATE_NAME("출발역과 도착역은 서로 이름이 달라야합니다."),
    STATION_NAME_SHORT("역 이름은 두 글자 이상 입력해주세요."),
    IMPOSSIBLE_FIND("연결되어 있지 않은 역입니다.");

    private final String message;

    SubwayErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
