package subway.controller;

import java.util.Scanner;
import subway.domain.InitialInfo;
import subway.domain.menu.Menu;
import subway.view.menu.MenuInputManager;
import subway.domain.menu.MenuKeys;
import subway.view.menu.MenuOutputManager;

public class MainController {
    private final MenuInputManager menuInputManager;
    private final SearchingPathController searchingPathController;
    public MainController(Scanner scanner){
        menuInputManager = new MenuInputManager(scanner);
        searchingPathController = new SearchingPathController(scanner, menuInputManager);
        initInfo();
    }

    private void initInfo() {
        new InitialInfo();
    }

    public void run() {
        while (true) {
            MenuOutputManager.printMenu(Menu.MAIN);
            String inputKey = menuInputManager.getMainInput();
            if (inputKey.equals(MenuKeys.EXIT.getKey())) {
                return;
            }
            runSystemByInput(inputKey);
        }
    }

    private void runSystemByInput(String inputKey) {
        if (inputKey.equals(MenuKeys.ONE.getKey())) {
            searchingPathController.run();
        }
    }

}
