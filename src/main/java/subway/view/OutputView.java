package subway.view;

public class OutputView {

    private static final String MAIN_TITLE = "## 메인 화면";
    private static final String MAIN_OPTION_ONE = "1. 경로 조회";
    private static final String MAIN_OPTION_TWO = "Q. 종료";

    public static void printMainScreen() {
        System.out.println(MAIN_TITLE);
        System.out.println(MAIN_OPTION_ONE);
        System.out.println(MAIN_OPTION_TWO);
    }
}
