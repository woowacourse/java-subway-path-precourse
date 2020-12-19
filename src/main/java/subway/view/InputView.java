package subway.view;

import java.util.Scanner;

public class InputView {

    public static String inputFunctionNumber(Scanner scanner) {
        System.out.println("## 원하는 기능을 선택하세요.");
        return scanner.next();
    }

    public static String inputStation(Scanner scanner, String type) {
        return inputStationByType(scanner, type);
    }

    private static String inputStationByType(Scanner scanner, String type) {
        System.out.printf("## %s역을 입력하세요.", type);
        System.out.println();
        return scanner.next();
    }
}
