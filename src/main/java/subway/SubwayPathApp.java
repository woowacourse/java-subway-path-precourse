package subway;

import subway.domain.exception.InvalidMenuSelectException;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.List;

public class SubwayPathApp {
    private final Scanner scanner;
    private final SearchPathMenu searchPathMenu;
    private boolean isAppEnd = false;

    public SubwayPathApp(Scanner scanner) {
        this.scanner = scanner;
        searchPathMenu = new SearchPathMenu(scanner);
        DummyData.initialize();
    }

    public void run() {
        do {
            printMenu();
            doSelectedMenu(selectMenu());
        } while (!isAppEnd);
    }

    private void printMenu() {
        List<String> menuNames = Arrays.stream(MAIN_MENU.values())
                .map(menu -> menu.menuName)
                .collect(Collectors.toList());
        OutputView.printMainMenu(menuNames);
    }

    private MAIN_MENU selectMenu() {
        try {
            return MAIN_MENU.of(InputView.selectMenu(scanner));
        } catch (Exception e) {
            OutputView.printError(e);
            return selectMenu();
        }
    }

    private void doSelectedMenu(MAIN_MENU selected) {
        if (selected == MAIN_MENU.SEARCH_PATH) {
            searchPathMenu.run();
        }

        if (selected == MAIN_MENU.EXIT) {
            setAppEnd();
        }
    }

    private void setAppEnd() {
        isAppEnd = true;
    }

    private enum MAIN_MENU {
        SEARCH_PATH("1", "1. 경로 조회"),
        EXIT("Q", "Q. 종료");

        private String code;
        private String menuName;

        MAIN_MENU(String code, String menuName) {
            this.code = code;
            this.menuName = menuName;
        }

        public static MAIN_MENU of(String userInput) {
            return Arrays.stream(values())
                    .filter(menu -> menu.code.equals(userInput))
                    .findFirst()
                    .orElseThrow(() -> new InvalidMenuSelectException());
        }
    }
}
