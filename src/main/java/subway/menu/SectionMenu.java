package subway.menu;

import java.util.Arrays;
import java.util.function.Consumer;
import subway.Scene;
import subway.controller.SectionViewController;

public enum SectionMenu {
    MIN_DISTANCE("1", "최단 거리", SectionViewController::findMinDistance),
    MIN_TIME("2", "최소 시간", SectionViewController::findMinTime),
    BACK("B", "돌아가기", SectionViewController::back);
    
    private String key;
    private String message;
    private Consumer<Scene> action;
    
    private SectionMenu(String key, String message, Consumer<Scene> action) {
        this.key = key;
        this.message = message;
        this.action = action;
    }
    
    public static Consumer<Scene> getAction(String input) {
        SectionMenu selectedMenu = Arrays.asList(SectionMenu.values()).stream()
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
