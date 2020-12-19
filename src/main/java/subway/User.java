package subway;

import java.util.Scanner;

public class User {

    private final Scanner scanner;

    public User(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getInput() {
        return scanner.nextLine();
    }
}
