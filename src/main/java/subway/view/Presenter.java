package subway.view;

import java.util.List;

public class Presenter {
    private static final String info = "[INFO] ";
    private static final String error = "[ERROR] ";

    private void selectFunction() {
        System.out.println("\n## 원하는 기능을 선택하세요.");
    }

    public void mainInfo() {
        System.out.println("\n" +
                "## 메인 화면\n" +
                "1. 경로 조회\n" +
                "Q. 종료");
        selectFunction();
    }

    public void pathInfo() {
        System.out.println("\n" +
                "## 경로 기준\n" +
                "1. 최단 거리\n" +
                "2. 최소 시간\n" +
                "B. 돌아가기");
        selectFunction();
    }

    public void inputStartingStation() {
        System.out.println("\n## 출발역을 입력하세요.");
    }

    public void inputDestinationStation() {
        System.out.println("\n## 도착역을 입력하세요.");
    }

    public void resultInfo(int totalDistance, int totalTime, List<String> path) {
        System.out.println("\n" +
                "## 조회 결과\n" +
                info + "---\n" +
                info + "총 거리: " + totalDistance + "km\n" +
                info + "총 소요 시간: " + totalTime + "분\n" +
                info + "---");
        printList(path);
    }

    private void printList(List<String> path) {
        path.forEach(station -> System.out.println(info + station));
    }

    public void sameStation() {
        System.out.println(error + "출발역과 도착역이 동일합니다.");
    }

    public void wrongInput() {
        System.out.println(error + "잘못된 입력입니다.");
    }

    public void noStation() {
        System.out.println(error + "없는 지하철 역입니다.");
    }
}
