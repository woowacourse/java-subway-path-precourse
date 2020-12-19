package subway.error;

public class SubwayException extends RuntimeException {
    public SubwayException(SubwayErrorMessage subwayErrorMessage) {
        super(subwayErrorMessage.getMessage());
    }
}
