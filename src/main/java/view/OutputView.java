package view;

public class OutputView {
    private static final String MAIN_MESSAGE = "## 메인 화면";
    private static final String PATH_CHECK = "1. 경로조회";
    private static final String QUIT = "Q. 종료";
    private static final String PATH_STANDARD_MESSAGE = "## 경로 기준";
    private static final String SHORTEST_DISTANCE = "1. 최단 거리";
    private static final String SHORTEST_TIME = "2. 최소 시간";
    private static final String BACK = "B. 돌아가기";

    private OutputView() {
    }

    public static void printMainScreen() {
        System.out.println(MAIN_MESSAGE);
        System.out.println(PATH_CHECK);
        System.out.println(QUIT);
        System.out.println();
    }

    public static void printPathStandardSelectionScreen() {
        System.out.println();
        System.out.println(PATH_STANDARD_MESSAGE);
        System.out.println(SHORTEST_DISTANCE);
        System.out.println(SHORTEST_TIME);
        System.out.println(BACK);
        System.out.println();
    }
}
