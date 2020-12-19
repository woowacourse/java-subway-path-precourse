package subway.utils;

public class OutputView {

    public static void printMainContents() {
        System.out.println("메인 화면");
        System.out.println("1. 경로 조회");
        System.out.println("Q. 종료");
        System.out.println();
        System.out.println("원하는 기능을 선택하세요.");
    }

    public static void printEndMessage() {
        System.out.println("종료합니다.");
    }

    public static void printPathContents() {
        System.out.println("경로 기준");
        System.out.println("1. 최단 거리");
        System.out.println("2. 최소 시간");
        System.out.println("B. 돌아가기");

        System.out.println("원하는 기능을 선택하세요.");
    }
}
