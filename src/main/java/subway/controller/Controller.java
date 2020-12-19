package subway.controller;

import java.util.Scanner;

public abstract class Controller {
    protected final Scanner scanner;

    protected Controller(Scanner scanner) {
        this.scanner = scanner;
    }

    public abstract void run();

    public abstract String selectMenu();
}
