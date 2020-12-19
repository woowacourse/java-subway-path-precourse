package subway.view;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String enterFeature() {
        System.out.println("## 원하는 기능을 선택하세요.");
        return scanner.nextLine();
    }

    public void enterCriteria() {

    }

    public void enterDepartualStation() {

    }

    public void enterArrivalStation() {

    }

    public String enterDeparture() {
        System.out.println("## 출발역을 입력하세요.");
        return scanner.nextLine();
    }

    public String enterArrival() {
        System.out.println("## 도착역을 입력하세요.");
        return scanner.nextLine();
    }
}
