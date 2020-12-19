package subway.menu;

import java.util.Arrays;
import java.util.function.BiConsumer;
import subway.Scene;
import subway.controller.MainViewController;
import subway.view.View;

public enum MainMenu {
    GO_SECTION_VIEW("1", "경로 조회", MainViewController::goSectionView), 
    EXIT("Q", "종료", MainViewController::exit);

    private String key;
    private String message;
    private BiConsumer<Scene, View> action;

    private MainMenu(String key, String message, BiConsumer<Scene, View> action) {
        this.key = key;
        this.message = message;
        this.action = action;
    }

    public static BiConsumer<Scene, View> getAction(String input) {
        MainMenu selectedMenu = Arrays.asList(MainMenu.values()).stream()
                .filter(menu -> input.equals(menu.key)).findFirst().orElse(null);
        if (selectedMenu == null) {
            return null;
        }
        return selectedMenu.action;
    }

    public String getKey() {
        return key;
    }

    public String getMessage() {
        return message;
    }
}
