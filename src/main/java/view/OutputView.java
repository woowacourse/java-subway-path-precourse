package view;

public class OutputView {
    private static final String MAIN_MESSAGE = "## 메인 화면";
    private static final String PATH_CHECK = "1. 경로조회";
    private static final String QUIT = "Q. 종료";

    private OutputView() {
    }

    public static void printMainScreen() {
        System.out.println(MAIN_MESSAGE);
        System.out.println(PATH_CHECK);
        System.out.println(QUIT);
        System.out.println();
    }

}
