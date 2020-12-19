package subway.view;

import java.util.List;

public class OutputView {

    public static void printMainMenu() {
        printMenu(MenuMessage.MAIN_MENU);
    }

    private static void printMenu(List<String> menuOptions) {
        System.out.println();
        menuOptions.forEach(System.out::println);
    }

    public static void printError(Exception e) {
        System.out.println();
        System.out.println(e.getMessage());
    }
}
