package subway.view;

import java.util.Scanner;

public class Input {
    public static final String ASK_COMMAND = "## 원하는 기능을 선택하세요.";

    public static String getInput(Scanner scanner) {
        System.out.println(ASK_COMMAND);
        return scanner.nextLine().trim();
    }
}
