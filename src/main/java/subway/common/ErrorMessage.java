package subway.common;

public class ErrorMessage {
    public static final String OUT = "OUT";

    private ErrorMessage() {
    }

    public static void print(ErrorCustomException errorCustomException) {
        System.out.println(errorCustomException.getMessage());
    }

}
