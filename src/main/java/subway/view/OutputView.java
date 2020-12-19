package subway.view;

import subway.exception.SubwayException;

public class OutputView {

    public static void printMainScreen() {
        System.out.println("## 메인 화면");
    }

    public static void chooseCategory() {
        System.out.println("## 원하는 기능을 선택하세요.");
    }

    public static void showErrorMessage(SubwayException exception) {
        System.out.println(exception.getMessage());
    }

    public static void printStartStation() {
        System.out.println("## 출발역을 입력하세요.");
    }

    public static void printEndStation() {
        System.out.println("## 도착역을 입력하세요.");
    }

    public static void printResult(){
        System.out.println("## 조회 결과");
    }

    public static void printPathScreen() {
        System.out.println("## 경로 기준");
    }
}
