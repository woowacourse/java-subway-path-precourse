package subway.views;

import java.util.Scanner;

public interface InputView {
    String LINE_WRAP = "\n";

    static String userInput(Scanner scanner) {
        return scanner.nextLine();
    }
}
