package subway.view;

import subway.domain.Station;

import java.util.Scanner;

public class InputView {
    private InputView() {
    }

    public static String getArrivalStation(Scanner scanner) {
        OutputView.println("## 도착역을 입력하세요.");
        return getInput(scanner);
    }

    public static String getDepartureStation(Scanner scanner) {
        OutputView.println("## 출발역을 입력하세요.");
        return getInput(scanner);
    }

    public static String selectMenu(Scanner scanner) {
        OutputView.println("## 원하는 기능을 선택하세요.");
        return getInput(scanner);
    }

    public static String getInput(Scanner scanner) {
        return scanner.nextLine();
    }
}
