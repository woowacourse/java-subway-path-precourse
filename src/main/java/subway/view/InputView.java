package subway.view;

import subway.controller.Validate;

import java.util.Scanner;

public class InputView {

    public static String askMenu(Scanner scanner, String regex) {
        System.out.println("\n## 원하는 기능을 선택하세요.");
        String userInput = scanner.nextLine();
        Validate.matchWithRegex(regex, userInput);
        return userInput;
    }
}