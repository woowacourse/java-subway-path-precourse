package subway.controller;

import java.util.Scanner;
import org.jgrapht.GraphPath;
import subway.common.ErrorCustomException;
import subway.common.ErrorMessage;
import subway.domain.PathRepository;
import subway.domain.menu.Menu;
import subway.view.menu.MenuInputManager;
import subway.domain.menu.MenuKeys;
import subway.view.menu.MenuOutputManager;
import subway.view.path.PathInputManager;
import subway.view.path.PathOutputManager;

public class SearchingPathController {

    private final MenuInputManager menuInputManager;
    private PathInputManager pathInputManager;

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
            searchShortestPath();
        }
        if (inputKey.equals(MenuKeys.TWO.getKey())) {
            System.out.println("최소시간");
        }
    }

    private void searchShortestPath() {
        try {
            String[] stations = pathInputManager.inputStations();
            GraphPath<String, String> targetPath = PathRepository
                .getShortestDistance(stations[0], stations[1]);
            PathOutputManager.printResultByShortestDistance(stations, targetPath);
        } catch (ErrorCustomException errorCustomException) {
            ErrorMessage.print(errorCustomException);
        }
    }
}
