package subway.service;

import java.util.Scanner;

import static subway.domain.MenuType.MAIN_SEARCH_PATH;
import static subway.domain.MenuType.SEARCH_PATH_MENU_RANGE;
import static subway.service.OutputView.printSearchPathMenu;

public class SubwayService extends InputService {
    private final SearchPathService searchPathService = new SearchPathService();

    public void selectMainMenu(Scanner scanner, String menu) {
        if (MAIN_SEARCH_PATH.isKeyEquals(menu)) {
            searchPathManagement(scanner);
        }
    }

    private void searchPathManagement(Scanner scanner) {
        try {
            printSearchPathMenu();
            String menu = inputSelectMenu(scanner, SEARCH_PATH_MENU_RANGE);
            if (!searchPathService.selectSearchPathMenu(scanner, menu)) {
                searchPathManagement(scanner);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            searchPathManagement(scanner);
        }
    }
}