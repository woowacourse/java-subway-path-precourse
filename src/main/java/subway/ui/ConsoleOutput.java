package subway.ui;

public class ConsoleOutput {
    private static final String GENERAL_MESSAGE_HEADER = "## ";
    private static final String ERROR_MESSAGE_HEADER = "[ERROR] ";
    private static final String INFO_MESSAGE_HEADER = "[INFO] ";

    private static final String GENERAL_MESSAGE_MAIN = "메인 화면";
    private static final String GENERAL_MESSAGE_PATH = "경로 기준";

    private static final String GENERAL_MESSAGE_FUNCTION = "원하는 기능을 선택하세요.";

    private ConsoleOutput() {
    }

    public static void printGeneralMessage(String message) {
        System.out.println();
        System.out.println(GENERAL_MESSAGE_HEADER + message);
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println();
        System.out.println(ERROR_MESSAGE_HEADER + errorMessage);
    }

    public static void printInfoMessage(String infoMessage) {
        System.out.println(INFO_MESSAGE_HEADER + infoMessage);
    }


    public static void printMainMenu() {
        printGeneralMessage(GENERAL_MESSAGE_MAIN);
        for (MainMenuEnum mainMenuEnum : MainMenuEnum.values()) {
            System.out.println(mainMenuEnum.getShortcut() + ". " + mainMenuEnum.getName());
        }
        printGeneralMessage(GENERAL_MESSAGE_FUNCTION);
    }
}
