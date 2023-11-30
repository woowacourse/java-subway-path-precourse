package subway.constant;

public enum Function {
    SEARCHING_ROUTE("1. 경로 조회"),
    QUIT("Q. 종료");

    public final String message;

    Function(String message) {
        this.message = message;
    }
    
}
