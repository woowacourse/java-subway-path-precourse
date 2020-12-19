package subway.controller;

import subway.domain.MainMenu;
import subway.utils.exception.InvalidMenuInputException;
import subway.view.InputView;
import subway.view.MainOutputView;

import java.util.Scanner;

public class MainController {
    MainOutputView mainOutputView;
    InputView inputView;
    MainMenu mainMenu;

    public MainController(Scanner scanner) {
        inputView = new InputView(scanner);
        mainOutputView = new MainOutputView();
    }

    public void run() {
        do {
            mainOutputView.printMainMenu(MainMenu.list());
            selectMenu();
        } while (mainMenu.isRunning());
    }

    private void selectMenu() {
        try {
            mainMenu = MainMenu.findMenu(inputMainMenu());
            mainMenu.start();
        } catch (InvalidMenuInputException e) {
            mainMenu = MainMenu.setRunningState();
        }
    }

    private String inputMainMenu() {
        try {
            mainOutputView.selectMenu();
            String menu = InputView.selectMenu();
            return menu;
        } catch (NullPointerException e) {
            return inputMainMenu();
        }
    }
}
