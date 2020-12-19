package subway.Views;

import java.util.Scanner;

public class InputView {
    private final static String FUNCTIONSELECTION = "## 원하는 기능을 선택하세요.";
    private final static String STARTSTATION = "## 출발역을 입력하세요.";
    private final static String ENDSTATION = "## 도착역을 입력하세요.";

    protected static String getUserInput(Scanner scanner) {
        System.out.println(FUNCTIONSELECTION);
        return scanner.nextLine();
    }

    protected static String getStartStation(Scanner scanner) {
        System.out.println(STARTSTATION);
        return scanner.nextLine();
    }

    protected static String getEndStation(Scanner scanner) {
        System.out.println(ENDSTATION);
        return scanner.nextLine();
    }
}
