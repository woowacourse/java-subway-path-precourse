package subway.exception;

public class SubwayProgramException extends IllegalArgumentException {
    private static final String PREFIX = "[ERROR] ";
    private static final String NEW_LINE = "\n";

    public SubwayProgramException(String errorMessage) {
        super(NEW_LINE + PREFIX + errorMessage );
    }
}
