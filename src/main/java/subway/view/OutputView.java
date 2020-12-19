package subway.view;

public class OutputView {
    private static final String MAIN_DISPLAY = "\n## 메인 화면\n1. 경로 조회\nQ. 종료";
    private static final String ERROR_MESSAGE_FORMAT = "\n[ERROR] %s\n";
    private static final String SUB_DISPLAY = "\n## 경로 기준\n1. 최단 거리\n2. 최소 시간\nB. 돌아가기";

    private OutputView() {      
    }

    public static void printMainDisplay() {
        System.out.println(MAIN_DISPLAY);
    }

    public static void printErrorMessage(RuntimeException e) {
        System.out.printf(ERROR_MESSAGE_FORMAT, e.getMessage());
    }

    public static void printSubDisplay() {
        System.out.println(SUB_DISPLAY);
    }
}
