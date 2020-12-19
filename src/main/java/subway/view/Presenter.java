package subway.view;

import java.util.List;

public class Presenter {
    private final String info = "[INFO] ";

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

    private void inputStartingStation() {
        System.out.println("\n## 출발역을 입력하세요.");
    }

    private void inputDestinationStation() {
        System.out.println("\n## 도착역을 입력하세요.");
    }

    public void resultInfo(int totalDistance, int totalTime, List<String> paths) {
        System.out.println("\n" +
                "## 조회 결과\n" +
                info + "---\n" +
                info + "총 거리: " + totalDistance + "km\n" +
                info + "총 소요 시간: " + totalTime + "분\n" +
                info + "---");
        printList(paths);
    }

    private void printList(List<String> paths) {
        paths.forEach(path -> System.out.println(info + path));
    }
}
