package subway.message;

public enum PrefixMessage implements Message{
    NOTICE_FORMAT("## %s"),
    INFO_FORMAT("[INFO] %s"),
    FUNCTION_FORMAT("%s. %s"),
    ERROR_FORMAT("[ERROR] %s"),
    ;

    private String message;

    PrefixMessage(String message){ this.message = message;}

    @Override
    public String getMessage() { return message;}
}
