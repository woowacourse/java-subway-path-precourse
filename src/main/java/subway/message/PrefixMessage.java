package subway.message;

public enum PrefixMessage implements Message{
    NOTICE_FORMAT("## %s"),
    INFO_FORMAT("[INFO] %s"),
    FUNCTION_FORMAT("%s. %s"),
    ERROR_FORMAT("[ERROR] %s"),
    KILOMETER_FORMAT("총 거리: %sKm"),
    TIME_FORMAT("총 소요 시간: %s분"),
    ;

    private String message;

    PrefixMessage(String message){ this.message = message;}

    @Override
    public String getMessage() { return message;}
}
