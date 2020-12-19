package subway.view;

import java.util.Scanner;

public class Input {
    private static Scanner scanner;

    public Input(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getMainFunction() {
        System.out.println("\n원하는 기능을 선택하세요");
        return getUserInput();
    }

    public String getStartStation() {
        System.out.println("\n출발역을 입력하세요.");
        return getUserInput();
    }

    public String getEndStation() {
        System.out.println("\n도착역을 입력하세요.");
        return getUserInput();
    }

    public String getUserInput() {
        return scanner.next();
    }

}
