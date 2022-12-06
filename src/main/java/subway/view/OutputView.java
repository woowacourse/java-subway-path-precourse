package subway.view;

public class OutputView {
    private static final String MAIN_PAGE_INFO = "## 메인 화면\n1. 경로 조회\nQ. 종료";
    private static final String PATH_PAGE_INFO = "## 경로 기준\n1. 최단 거리\n2. 최소 시간\nB. 돌아가기";

    public static void printMainPage() {
        System.out.println(MAIN_PAGE_INFO);
    }

    public static void print(String message) {
        System.out.println();
        System.out.println(message);
    }

    public static void printPathPage() {
        System.out.println(PATH_PAGE_INFO);
    }

}
