package subway;

public class CommonPrinter {
    public static final String INFO_PREFIX = "[INFO] ";
    public static final String ERROR_PREFIX = "[ERROR] ";
    private static final String INFO_SPLIT_LINE = INFO_PREFIX + "---";
    private static final String USER_SELECTION_MESSAGE
        = "\n## 원하는 기능을 선택하세요.";

    public static void printUserSelectionMessage() {
        System.out.println(USER_SELECTION_MESSAGE);
    }

    public static void printInfoSplitLine() {
        System.out.println(INFO_SPLIT_LINE);
    }
}
