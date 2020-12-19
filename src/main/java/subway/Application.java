package subway;

import java.io.PrintStream;
import java.util.Scanner;
import subway.controller.MainController;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final PrintStream printStream = new PrintStream(System.out);
        final MainController mainController = new MainController(scanner, printStream);
        mainController.run();
    }
}
