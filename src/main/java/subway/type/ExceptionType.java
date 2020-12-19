package subway.type;

public enum ExceptionType {
    ERROR("[ERROR] "),

    INVALID_OPTION_CHOICE(ERROR.getException() + "화면에 나타난 기능만 선택 가능합니다.\n"),

    INVALID_SAME_STATIONS(ERROR.getException() + "출발역과 도착역이 동일합니다.\n"),
    INVALID_EXISTING_STATIONS(ERROR.getException() + "출발역 또는 도착역이 존재하지 않습니다.\n");

    private final String exception;

    ExceptionType(String exception) {
        this.exception = exception;
    }

    public String getException() {
        return exception;
    }
}
