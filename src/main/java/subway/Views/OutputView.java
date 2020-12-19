package subway.Views;

public class OutputView {
    private final static String MAINSCREEN = "## 메인 화면";
    private final static String ROUTESEARCHSELECTION = "1. 경로 조회";
    private final static String PROGRAMEXIT = "Q. 종료";

    protected static void printMainSelection(){
        System.out.println(MAINSCREEN);
        System.out.println(ROUTESEARCHSELECTION);
        System.out.println(PROGRAMEXIT);
        System.out.println();
    }
}
