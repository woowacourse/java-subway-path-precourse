package subway.view;

public class InputView {
    public static void printMainInput() {
        System.out.println();
        System.out.println("## 메인 화면");
        System.out.println("1. 경로 조회");
        System.out.println("Q. 종료");
        System.out.println();
        printFunctionInput();
    }

    public static void printPathMenuInput() {
        System.out.println();
        System.out.println("## 경로 기준");
        System.out.println("1. 최단 거리");
        System.out.println("2. 최소 시간");
        System.out.println("B. 돌아가기");
        System.out.println();
        printFunctionInput();
    }

    public static void printStartStationInput() {
        System.out.println();
        System.out.println("## 출발역을 입력하세요");
    }

    public static void printEndStationInput() {
        System.out.println();
        System.out.println("## 도착역을 입력하세요");
    }

    public static void printFunctionInput() {
        System.out.println("## 원하는 기능을 선택하세요");
    }
}
