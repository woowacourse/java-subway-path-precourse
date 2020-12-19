package subway.menu;

import java.util.Arrays;
import java.util.function.BiConsumer;
import subway.Scene;
import subway.controller.SectionViewController;
import subway.view.View;

public enum SectionMenu {
    MIN_DISTANCE("1", "최단 거리", SectionViewController::findMinDistance),
    MIN_TIME("2", "최소 시간", SectionViewController::findMinTime),
    BACK("B", "돌아가기", SectionViewController::back);

    private String key;
    private String message;
    private BiConsumer<Scene, View> action;

    private SectionMenu(String key, String message, BiConsumer<Scene, View> action) {
        this.key = key;
        this.message = message;
        this.action = action;
    }

    public static BiConsumer<Scene, View> getAction(String input) {
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
