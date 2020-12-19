package subway.controller;

import java.util.List;
import java.util.Scanner;
import subway.common.ErrorCustomException;
import subway.common.ErrorMessage;
import subway.domain.PathRepository;
import subway.domain.Menu;
import subway.view.menu.MenuInputManager;
import subway.domain.MenuKeys;
import subway.view.menu.MenuOutputManager;
import subway.view.path.PathInputManager;
import subway.view.path.PathOutputManager;

public class SearchingPathController {
    private final MenuInputManager menuInputManager;
    private final PathInputManager pathInputManager;

    SearchingPathController(Scanner scanner, MenuInputManager menuInputManager) {
        this.menuInputManager = menuInputManager;
        pathInputManager = new PathInputManager(scanner);
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
            searchShortestDistance();
        }
        if (inputKey.equals(MenuKeys.TWO.getKey())) {
            searchShortestTime();
        }
    }

    private void searchShortestTime() {
        try {
            String[] stations = pathInputManager.inputStations();
            List<String> path = PathRepository.getListByShortestTime(stations[0], stations[1]);
            PathOutputManager.printResult(path);
        } catch (ErrorCustomException errorCustomException) {
            ErrorMessage.print(errorCustomException);
        }
    }

    private void searchShortestDistance() {
        try {
            String[] stations = pathInputManager.inputStations();
            List<String> path = PathRepository.getListByShortestDistance(stations[0], stations[1]);
            PathOutputManager.printResult(path);
        } catch (ErrorCustomException errorCustomException) {
            ErrorMessage.print(errorCustomException);
        }
    }

}
