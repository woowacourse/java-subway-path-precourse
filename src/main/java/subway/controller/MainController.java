package subway.controller;

import subway.controller.enums.MainMenu;
import subway.service.InitializationService;
import subway.view.inputview.MainView;

import java.util.Scanner;

public class MainController extends Controller {
    private static MainController mainController;
    private MainMenu mainMenu;
    private MainView mainView;
    private static final String QUIT = "Q";

    private MainController(Scanner scanner) {
        super(scanner);
        mainView = MainView.getInstance(scanner);
    }

    public static MainController getInstance(Scanner scanner) {
        if (mainController == null) {
            mainController = new MainController(scanner);
        }

        return mainController;
    }

    @Override
    public void run() {
        InitializationService.init();

        while (true) {
            mainView.showOption();
            mainMenu = MainMenu.findMainMenu(selectMenu());
            mainMenu.run();

            if (mainMenu.getType().equals(QUIT)) {
                return;
            }
        }
    }

    @Override
    public String selectMenu() {
        try {
            String selectedMenu = mainView.inputCommand();
            return selectedMenu;
        } catch (IllegalArgumentException e) {
            super.outputView.printError(e.getMessage());
            return selectMenu();
        }
    }
}
