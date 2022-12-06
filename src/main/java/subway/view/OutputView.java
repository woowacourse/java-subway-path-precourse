package subway.view;

public class OutputView {
    private static final String MAIN_PAGE_INFO = "## 메인 화면\n1. 경로 조회\nQ. 종료";

    public static void printMainPage() {
        System.out.println(MAIN_PAGE_INFO);
    }

    public static void print(String message) {
        System.out.println();
        System.out.println(message);
    }

}
