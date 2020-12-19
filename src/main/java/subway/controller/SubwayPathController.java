package subway.controller;

import java.util.Scanner;

import subway.menu.MainMenu;
import subway.view.InputView;

public class SubwayPathController {
    private InputView inputView;
    private MainMenu mainMenu;

    public SubwayPathController(Scanner scanner) {
        inputView = new InputView(scanner);
        mainMenu = new MainMenu(inputView);
    }

    public void run() {
        mainMenu.runMainMenu();
    }
}
