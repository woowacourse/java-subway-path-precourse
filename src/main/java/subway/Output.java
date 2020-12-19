package subway;

public class Output {
    private static final String MAIN_VIEW = "## 메인 화면";
    private static final String ROUTE_SEARCH = "1. 경로 조회";
    private static final String QUIT = "Q. 종료";
    private static final String[] MAIN_LIST = {MAIN_VIEW, ROUTE_SEARCH, QUIT};

    public static void printMainView() {
        for (int i = 0; i < MAIN_LIST.length; i++) {
            System.out.println(MAIN_LIST[i]);
        }
        System.out.println();
    }
}
