package subway.common;

public class CommonPrinter {

    public static final String ERROR_PREFIX = "[ERROR] ";
    private static final String USER_SELECTION_MESSAGE
        = "\n## 원하는 기능을 선택하세요.";
    private static final String USER_SELECTION_INPUT_ERROR_MESSAGE
        = "\n" + ERROR_PREFIX + "사용할 수 없는 기능입니다.";

    public static void printUserSelectionMessage() {
        System.out.println(USER_SELECTION_MESSAGE);
    }

    public static void printUserSelectionInputErrorMessage() {
        System.out.println(USER_SELECTION_INPUT_ERROR_MESSAGE);
    }
}
