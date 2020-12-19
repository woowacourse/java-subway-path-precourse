package subway.view;

public class OutputView {
    private static final String MAIN_DISPLAY = "## 메인 화면\n1. 경로 조회\nQ. 종료";

    private OutputView() {      
    }

    public static void printMainDisplay() {
        System.out.println(MAIN_DISPLAY);
    }
}
