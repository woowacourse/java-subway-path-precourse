package subway.view;

public class Display {

    private static final String NOTICE_PREFIX = "## ";
    private static final String INFO_PREFIX = "[INFO] ";
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String NO_SUCH_MENU = "선택할 수 없는 기능입니다.";

    public static void printNotice(String message) {
        System.out.println(NOTICE_PREFIX + message);
    }

    public static void printInformation(String message) {
        System.out.println(INFO_PREFIX + message);
    }

    public static void printError(String message) {
        System.out.println(ERROR_PREFIX + message);
    }

    public static void printMenuSelectError(){
        System.out.println(ERROR_PREFIX + NO_SUCH_MENU);
    }
}
