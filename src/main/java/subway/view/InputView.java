package subway.view;

import java.util.Scanner;

public class InputView {

    public static String inputFunctionNumber(Scanner scanner) {
        scanner = new Scanner(System.in);
        System.out.println("## 원하는 기능을 선택하세요.");
        return scanner.next();
    }
}
