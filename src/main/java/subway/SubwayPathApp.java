package subway;

import subway.view.InputView;
import subway.view.OutputView;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.List;

public class SubwayPathApp {
    private final Scanner scanner;
    private boolean isAppEnd = false;

    public SubwayPathApp(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        do {
            printMenu();
            selectMenu();
        } while (!isAppEnd);
    }

    private void printMenu() {
        List<String> menuNames = Arrays.stream(MAIN_MENU.values())
                .map(menu -> menu.menuName)
                .collect(Collectors.toList());
        OutputView.printMainMenu(menuNames);
    }

    private MAIN_MENU selectMenu() {
        return MAIN_MENU.of(InputView.selectMainMenu(scanner));
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
                    .orElseThrow(() -> new IllegalArgumentException("적절하지 않은 기능 선택입니다."));
        }
    }
}
