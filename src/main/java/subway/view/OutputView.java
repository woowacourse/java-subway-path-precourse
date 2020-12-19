package subway.view;

public class OutputView {
    private static final String RESULT_PREFIX = "[INFO] ";
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String GUIDE_PREFIX = "## ";

    public static void printError(String message) {
        System.out.println();
        print(ERROR_PREFIX + message);
    }

    public static void printResult(String message) {
        print(RESULT_PREFIX + message);
    }

    public static void printlnResult(String message) {
        System.out.println();
        print(RESULT_PREFIX + message);
    }

    public static void printGuide(String message) {
        System.out.println();
        print(GUIDE_PREFIX + message);
    }

    public static void print(String message) {
        System.out.println(message);
    }
}
