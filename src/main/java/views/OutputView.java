package views;

public class OutputView {

    public static void mainView() {
        System.out.println("\n## 메인화면");
        System.out.println("1. 경로 조회");
        System.out.println("Q. 종료");
    }

    public static void path_standardView() {
        System.out.println("\n## 경로 기준");
        System.out.println("1. 최단 거리");
        System.out.println("2. 최소 시간");
        System.out.println("B. 돌아가기");
    }

    public static void path_lookup_result() {
        System.out.println("\n## 조회 결과");
    }
}
