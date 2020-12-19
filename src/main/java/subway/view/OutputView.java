package subway.view;

public class OutputView {
    private static final String MAIN_DISPLAY = "\n## 메인 화면\n1. 경로 조회\nQ. 종료";
    private static final String SUCCESS_MESSAGE_FORMAT = "\n[INFO] %s";
    private static final String CONTOUR = "---";
    private static final String ERROR_MESSAGE_FORMAT = "\n[ERROR] %s\n";
    private static final String SUB_DISPLAY = "\n## 경로 기준\n1. 최단 거리\n2. 최소 시간\nB. 돌아가기";
    private static final String VIEW_RESULT = "\n## 조회 결과";
    private static final String TOTAL_DISTANCE = "총 소요 시간: %dkm";
    private static final String TOTAL_TIME = "총 소요 시간: %d분";

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

    public static void printSuccessDisplay() {
        System.out.print(VIEW_RESULT);
        System.out.printf(SUCCESS_MESSAGE_FORMAT, CONTOUR);
        String total_distance = String.format(TOTAL_DISTANCE, 0);
        System.out.printf(SUCCESS_MESSAGE_FORMAT, total_distance);
        String total_time = String.format(TOTAL_TIME, 0);
        System.out.printf(SUCCESS_MESSAGE_FORMAT, total_time);
        System.out.printf(SUCCESS_MESSAGE_FORMAT, CONTOUR);
        // 경로
        System.out.println();
    }
}
