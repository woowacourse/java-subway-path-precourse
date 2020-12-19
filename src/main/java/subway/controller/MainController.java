package subway.controller;

import subway.domain.menu.MainMenu;
import subway.utils.exception.InvalidMenuInputException;
import subway.view.InputView;
import subway.view.output.MainOutputView;

public class MainController implements Controller {
    MainOutputView mainOutputView;
    MainMenu mainMenu;

    public MainController() {
        mainOutputView = new MainOutputView();
    }

    @Override
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
