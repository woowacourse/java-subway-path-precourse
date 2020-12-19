package subway.domain.exception;

@SuppressWarnings("serial")
public class NullStationException extends IllegalStateException {
    private static final String MESSAGE = "해당 역은 존재하지 않습니다. (input:\"%s\")";

    public NullStationException(String input) {
        super(String.format(MESSAGE, input));
    }
}
