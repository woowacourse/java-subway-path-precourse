package subway.view;

public class OutputView {
    private static final String MAIN_DISPLAY = "## 메인 화면\n1. 경로 조회\nQ. 종료";
    private static final String ERROR_MESSAGE_FORMAT = "\n[ERROR] %s\n";

    private OutputView() {      
    }

    public static void printMainDisplay() {
        System.out.println(MAIN_DISPLAY);
    }

    public static void printErrorMessage(RuntimeException e) {
        System.out.printf(ERROR_MESSAGE_FORMAT, e.getMessage());
    }
}
