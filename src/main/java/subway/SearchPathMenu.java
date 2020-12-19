package subway;

import subway.view.InputView;
import subway.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SearchPathMenu {
    private final Scanner scanner;
    private boolean isAppEnd = false;

    public SearchPathMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        printMenu();
        selectMenu();
        // TODO :: 기능 수행
    }

    private void printMenu() {
        List<String> menuNames = Arrays.stream(SEARCH_MENU.values())
                .map(menu -> menu.menuName)
                .collect(Collectors.toList());
        OutputView.printMainMenu(menuNames);
    }

    private SEARCH_MENU selectMenu() {
        return SEARCH_MENU.of(InputView.selectMenu(scanner));
    }

    private enum SEARCH_MENU {
        SEARCH_BY_DISTANCE("1", "1. 최단 거리 조회"),
        SEARCH_BY_TIME("2", "2. 최단 시간 조회"),
        EXIT("B", "B. 돌아가기");

        private String code;
        private String menuName;

        SEARCH_MENU(String code, String menuName) {
            this.code = code;
            this.menuName = menuName;
        }

        public static SEARCH_MENU of(String userInput) {
            return Arrays.stream(values())
                    .filter(menu -> menu.code.equals(userInput))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("적절하지 않은 기능 선택입니다."));
        }
    }
}
