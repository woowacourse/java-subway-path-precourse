package subway.console;

public class MainScreen {
    private static final String MAIN_SCREEN_OUTPUT = "## 메인 화면\n1. 경로 조회\nQ. 종료";

    public MainScreen() {
    }

    public static void startProcess() {
        printMainScreenOutput();
        MainMenu.executeMenuByInput(Input.getMainScreenInput());
    }

    private static void printMainScreenOutput() {
        System.out.println(MAIN_SCREEN_OUTPUT);
    }

}
