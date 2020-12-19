package subway.view;

public class OutputView {

    private static final String MAIN_PAGE = "## 메인 화면\n" +
            "1. 경로 조회\n" +
            "Q. 종료\n";
    private static final String ROUTE_PAGE = "## 경로 기준\n" +
            "1. 최단 거리\n" +
            "2. 최소 시간\n" +
            "B. 돌아가기\n";

    public static void print(String string){
        System.out.println(string);
    }

    public static void mainPage(){
        print(MAIN_PAGE);
    }

    public static void routePage() {
        print(ROUTE_PAGE);
    }
}
