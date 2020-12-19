package subway.view;

import java.util.Scanner;

public class InputView {

    public static Scanner scanner;

    public static String inputString() {
        return scanner.nextLine();
    }

    public static String inputStation() {
        String input = scanner.nextLine();
        if (input.isBlank() || input.equals("")) {
            throw new IllegalArgumentException("[ERROR] 역 이름을 입력해주세요.");
        }
        return input;
    }

}
