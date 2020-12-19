package subway.controller;

import java.util.Scanner;
import subway.domain.ShortestPathRepository;
import subway.domain.menu.Menu;
import subway.domain.menu.MenuInputManager;
import subway.domain.menu.MenuKeys;
import subway.domain.menu.MenuOutputManager;

public class SearchingPathController {

    private final MenuInputManager menuInputManager;

    SearchingPathController(MenuInputManager menuInputManager) {
        this.menuInputManager = menuInputManager;
    }

    public void run() {
        while (true) {
            MenuOutputManager.printMenu(Menu.SEARCH_PATH);
            String inputKey = menuInputManager.getPathInput();
            if (inputKey.equals(MenuKeys.BACK.getKey())) {
                return;
            }
            runSystemByInput(inputKey);
        }
    }

    private void runSystemByInput(String inputKey) {
        if (inputKey.equals(MenuKeys.ONE.getKey())) {
            searchShortestPath();
        }
        if (inputKey.equals(MenuKeys.TWO.getKey())) {
            System.out.println("최소시간");
        }
    }

    private void searchShortestPath() {
        try {
            System.out.println(ShortestPathRepository.getShortestDistance("교대역", "역삼역"));
            System.out.println("최단거리");
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
    }
}
