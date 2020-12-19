package subway.view;

public class ErrorView {
    protected static final String ERROR_SIGN = "[ERROR] ";
    private static final String ERROR_WRONG_OPTION = "선택할 수 없는 기능입니다.";

    protected static void printError(String errorMessage) {
        System.out.println(ERROR_SIGN + errorMessage);
        System.out.println();
    }

    public static void printOptionError() {
        printError(ERROR_WRONG_OPTION);
    }
}
