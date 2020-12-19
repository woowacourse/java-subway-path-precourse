package subway.view;

public class OutputView {
    public static void printMainMenu() {
        System.out.println("## 메인 화면");
        System.out.println("1. 경로 조회");
        System.out.println("Q. 종료");
        println();
    }

    public static void printRouteMenu() {
        println();
        System.out.println("## 경로 기준");
        System.out.println("1. 최단 거리");
        System.out.println("2. 최소 시간");
        System.out.println("B. 돌아가기");
        println();
    }

    public static void printMenuSelectionGuide() {
        System.out.println("## 원하는 기능을 선택하세요.");
    }

    public static void printError(String error) {
        System.out.println(error);
        println();
    }

    public static void println() {
        System.out.println();
    }
}
