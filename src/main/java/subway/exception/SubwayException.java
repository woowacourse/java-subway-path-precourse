package subway.exception;

public class SubwayException extends Exception {
    private final String ERROR = "[ERROR] ";

    public SubwayException(String message) {
        System.out.println(ERROR + message);
    }
}
