package subway.view;

import java.util.Arrays;

public class MainConsole {
    private static final String CURRENT_MENU_VIEW = "## 메인 화면";

    public void showMenu() {
        System.out.println(CURRENT_MENU_VIEW);
        Arrays.stream(MainMenu.values())
                .forEach(menu -> {
                    System.out.println(menu.getKey() + ". " + menu.getMenuList());
                });
    }

    public MainMenu selectMenu() {
        while (true) {
            String input = InputView.getMenu();
            if (!MainMenu.isValidKey(input)) {
                OutputView.cannotSelectMenuError();
                continue;
            }
            return MainMenu.moveByKey(input);
        }
    }
}
