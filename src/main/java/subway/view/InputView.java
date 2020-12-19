package subway.view;

import java.util.Scanner;

public class InputView {

    public static Scanner scanner;

    public static String inputString() {
        String input = scanner.nextLine();
        System.out.println();
        return input;
    }

    public static String inputStation() {
        String input = scanner.nextLine();
        if (input.isBlank() || input.equals("")) {
            throw new IllegalArgumentException("[ERROR] 역 이름을 입력해주세요.");
        }
        System.out.println();
        return input;
    }

}
