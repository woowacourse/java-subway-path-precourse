package subway.view;

public class OutputView {

    private static final String MAIN_PAGE = "## 메인화면\n" +
            "1. 경로 조회\n" +
            "Q. 종료\n";

    public static void print(String string){
        System.out.println(string);
    }

    public static void mainPage(){
        print(MAIN_PAGE);
    }
}
