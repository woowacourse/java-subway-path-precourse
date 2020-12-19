package subway.view;

import java.util.Scanner;

public class InputView {
    public static String scanMainInput(Scanner scanner) {
        return scanner.nextLine();
    }

    public static String scanPathInput(Scanner scanner) {
        return scanner.nextLine();
    }

    public static String scanOriginInput(Scanner scanner) {
        OutputView.printOriginText();
        return scanner.nextLine();
    }

    public static String scanDestinationInput(Scanner scanner) {
        OutputView.printDestinationText();
        return scanner.nextLine();
    }
}
