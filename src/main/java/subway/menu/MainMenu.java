package subway.menu;

import java.util.Arrays;
import java.util.function.Consumer;
import subway.Scene;
import subway.controller.MainViewController;

public enum MainMenu {
    GO_SECTION_VIEW("1", "경로 조회", MainViewController::goSectionView), 
    EXIT("Q", "종료", MainViewController::exit);

    private String key;
    private String message;
    private Consumer<Scene> action;

    private MainMenu(String key, String message, Consumer<Scene> action) {
        this.key = key;
        this.message = message;
        this.action = action;
    }

    public static Consumer<Scene> getAction(String input) {
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
