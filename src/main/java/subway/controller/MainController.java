package subway.controller;

import java.util.Scanner;
import subway.domain.menu.Menu;
import subway.domain.menu.MenuInputManager;
import subway.domain.menu.MenuKeys;
import subway.domain.menu.MenuOutputManager;

public class MainController {
    private final MenuInputManager menuInputManager;
    private final SearchingPathController searchingPathController;
    public MainController(Scanner scanner){
        menuInputManager = new MenuInputManager(scanner);
        searchingPathController = new SearchingPathController(menuInputManager);
        initInfo();
    }
    //todo : 정보 초기화
    private void initInfo() {
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
