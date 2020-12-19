package subway.view;

import java.util.Arrays;

public class SubwayPathConsole {
    private static final String CURRENT_MENU_VIEW = "\n## 경로 기준";

    public static void showMenu() {
        System.out.println(CURRENT_MENU_VIEW);
        Arrays.stream(SubwayPathMenu.values())
                .forEach(menu -> {
                    System.out.println(menu.getKey() + ". " + menu.getMenuList());
                });
    }

    public static boolean selectMenu() {
        while (true) {
            showMenu();
            String input = InputView.getMenu();
            if (!SubwayPathMenu.isValidKey(input)) {
                OutputView.cannotSelectMenuError();
            }
            if(!SubwayPathMenu.moveByKey(input).moveNext()) {
                continue;
            }
            break;
        }
        return false;
    }
}
