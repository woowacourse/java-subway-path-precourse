package views;

import subway.Category.Validator;

import java.util.List;
import java.util.Scanner;

public class InputView {

    public static String inputFunction(Scanner scanner, List<String> actionType) {
        try {
            System.out.println("\n## 원하는 기능을 선택하세요.");
            String input = scanner.next();
            Validator.isValidCategory(input, actionType);
            return input;
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            return inputFunction(scanner, actionType);
        }
    }

    public static String inputStartStation(Scanner scanner) {
        System.out.println("\n## 출발역을 입력하세요.");
        return scanner.next();
    }

    public static String inputArriveStation(Scanner scanner) {
        System.out.println("\n## 도착역을 입력하세요.");
        return scanner.next();
    }
}
