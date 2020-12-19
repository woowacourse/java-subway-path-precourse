package subway.view;

public class OutputView {
    private static final String ERROR_MESSAGE_FORMAT = "\n[ERROR] %s\n";

    private OutputView() {
    }

    public static void printErrorMessage(RuntimeException runtimeException) {
        System.out.printf(ERROR_MESSAGE_FORMAT, runtimeException.getMessage());
    }
}
