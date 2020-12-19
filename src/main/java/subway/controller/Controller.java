package subway.controller;

import subway.view.OutputView;

import java.util.Scanner;

public abstract class Controller {
    protected final Scanner scanner;
    protected OutputView outputView;

    protected Controller(Scanner scanner) {
        this.scanner = scanner;
        this.outputView = OutputView.getInstance();
    }

    public abstract void run();

    public abstract String selectMenu();
}
