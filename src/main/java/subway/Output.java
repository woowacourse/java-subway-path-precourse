package subway;

public class Output {

    private static final String MAIN_VIEW = "## 메인 화면";
    private static final String ROUTE_SEARCH = "1. 경로 조회";
    private static final String QUIT = "Q. 종료";
    private static final String[] MAIN_LIST = {MAIN_VIEW, ROUTE_SEARCH, QUIT};
    private static final String ERROR = "[ERROR] ";
    private static final String BAD_CHOICE = "목록에 없는것을 선택하셨습니다.\n";
    private static final String ROUTE_VIEW = "## 경로 기준";
    private static final String MIN_DISTANCE = "1. 최단 거리";
    private static final String SHORT_TIME = "2. 최소 시간";
    private static final String BACK = "B. 돌아가기";
    private static final String[] ROUTE_LIST = {ROUTE_VIEW, MIN_DISTANCE, SHORT_TIME, BACK};

    private static void printView(String[] strArray) {
        for (String str : strArray) {
            System.out.println(str);
        }
        System.out.println();
    }

    public static void printMainView() {
        printView(MAIN_LIST);
    }

    public static void printChoiceErrorMessage() {
        System.out.println(ERROR + BAD_CHOICE);
    }

    public static void printRouteSearchView() {
        printView(ROUTE_LIST);
    }
}
