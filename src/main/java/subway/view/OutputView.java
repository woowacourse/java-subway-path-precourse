package subway.view;

public class OutputView {

    private static final String MAIN_PAGE = "## 메인 화면\n" +
            "1. 경로 조회\n" +
            "Q. 종료\n";
    private static final String ROUTE_PAGE = "## 경로 기준\n" +
            "1. 최단 거리\n" +
            "2. 최소 시간\n" +
            "B. 돌아가기\n";
    private static final String INFO = "[INFO] ";
    private static final String BAR = "---";
    private static final String TOTAL_LENGTH = "총 거리 : ";
    private static final String KM = "km";
    private static final String TOTAL_TIME = "총 시간 : ";
    private static final String MINUTE = "분";
    private static final String SPACE = "";

    public static void print(String string) {
        System.out.println(string);
    }

    public static void mainPage() {
        print(MAIN_PAGE);
    }

    public static void routePage() {
        print(ROUTE_PAGE);
    }

    public static void status(String string) {
        print(INFO + string);
    }

    public static void bar() {
        print(INFO + BAR);
    }

    public static void totalLength(int length) {
        print(INFO + TOTAL_LENGTH + length + KM);
    }

    public static void totalTime(int time) {
        print(INFO + TOTAL_TIME + time + MINUTE);
    }

    public static void space() {
        print(SPACE);
    }
}
