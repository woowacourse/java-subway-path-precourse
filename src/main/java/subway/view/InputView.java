package subway.view;

public class InputView {
    private static final char NEW_LINE = '\n';

    public void inputSelectMenuMessage() {
        System.out.println(NEW_LINE+"## 원하는 기능을 선택하세요.");
    }

    public void inputStartStationNameMessage() {
        System.out.println(NEW_LINE+"## 출발역을 입력하세요.");
    }

    public void inputEndStationNameMessage() {
        System.out.println(NEW_LINE+"## 도착역을 입력하세요.");
    }
}