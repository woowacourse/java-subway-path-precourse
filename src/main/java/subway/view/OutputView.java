package subway.view;

import subway.exception.SubwayException;

public class OutputView {

    public static final String DIVIDER = "---";

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

    public static void printResult(int distance, int time){
        System.out.println("## 조회 결과");
        showInfoMessage(DIVIDER);
        showInfoMessage("총 거리: " + distance +"km");
        showInfoMessage("총 소요 시간: " + time + "분");
        showInfoMessage(DIVIDER);
    }

    public static void printPathScreen() {
        System.out.println("## 경로 기준");
    }

    public static void showInfoMessage(String message){
        System.out.println("[INFO] " + message);
    }

}
