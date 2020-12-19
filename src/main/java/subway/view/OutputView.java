package subway.view;

public class OutputView {

    private static final String MAIN_TITLE = "## 메인 화면";
    private static final String MAIN_OPTION_ONE = "1. 경로 조회";
    private static final String MAIN_OPTION_TWO = "Q. 종료";
    private static final String PATH_TITLE = "## 경로 기준";
    private static final String PATH_OPTION_ONE = "1. 최단 거리";
    private static final String PATH_OPTION_TWO = "2. 최소 시간";
    private static final String PATH_OPTION_BACK = "B. 돌아가기";
    private static final String SEARCH_RESULT = "## 조회 결과";
    private static final String INFO_PREFIX = "[INFO] ";
    private static final String DASHED_LINE = "---";
    private static final String TOTAL_DISTANCE = "총 거리 ";
    private static final String TOTAL_TIME = "총 소요 시간";

    public static void printMainScreen() {
        System.out.println(MAIN_TITLE);
        System.out.println(MAIN_OPTION_ONE);
        System.out.println(MAIN_OPTION_TWO);
    }

    public static void printPathManagerScreen() {
        System.out.println(PATH_TITLE);
        System.out.println(PATH_OPTION_ONE);
        System.out.println(PATH_OPTION_TWO);
        System.out.println(PATH_OPTION_BACK);
    }

    public static void printResult(String result) {
        System.out.println(SEARCH_RESULT);
        System.out.println(INFO_PREFIX + DASHED_LINE);
        System.out.println(INFO_PREFIX + TOTAL_DISTANCE);
        System.out.println(INFO_PREFIX + TOTAL_TIME);
        System.out.println(INFO_PREFIX + DASHED_LINE);
        System.out.println();
    }
}
