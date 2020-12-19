package subway.view;

public class OutputView {
    private static final String ERROR_PREFIX = "[ERROR]";

    public static void printErrorMessage(Exception e) {
        System.out.println(ERROR_PREFIX + e.getMessage());
    }
}
