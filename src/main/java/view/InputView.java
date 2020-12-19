package view;

import java.util.Scanner;

public class InputView {
    public static Scanner scanner;

    public static String inputWithHintMessage(String hint) {
        OutputView.print(hint);
        return scanner.nextLine();
    }
}
