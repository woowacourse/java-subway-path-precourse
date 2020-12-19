package subway.console;

public class MainScreen {
    private static final String MAIN_SCREEN_OUTPUT = "\n## 메인 화면\n1. 경로 조회\nQ. 종료";
    private static String mainScreenInput;

    public MainScreen() {
    }

    public static void startProcess() {
        do {
            printMainScreenOutput();
            mainScreenInput = Input.getMainScreenInput();
            executeMenu();
        } while (!mainScreenInput.equals(MainMenu.QUIT.getSymbol()));
    }

    private static void executeMenu() {
        try {
            MainMenu.executeMenuByInput(mainScreenInput);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printMainScreenOutput() {
        System.out.println(MAIN_SCREEN_OUTPUT);
    }
}
