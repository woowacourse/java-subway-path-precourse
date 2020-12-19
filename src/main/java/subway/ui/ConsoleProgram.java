package subway.ui;

import java.util.Scanner;
import subway.util.Initializer;

public class ConsoleProgram {

    private final Scanner scanner;

    public ConsoleProgram(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        Initializer.initializeRepositories();
        MainMenu mainMenu = new MainMenu(scanner);
        mainMenu.run();
    }

}
