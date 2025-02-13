package subway.screen.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public final class MenuEventManager {
    private static final String NOT_RECEIVED_MENU_MESSAGE = "메뉴를 전달받지 못하였습니다.";
    private static final String NOT_RECEIVED_HANDLER_MESSAGE = "이벤트 핸들러를 전달받지 못하였습니다.";

    private final Map<Menu, Runnable> handlerMap = new HashMap<>();

    private MenuEventManager() {
    }

    public static MenuEventManager builder() {
        return new MenuEventManager();
    }

    public MenuEventManager addEventListener(Menu menu) {
        return this.addEventListener(menu, () -> {
        });
    }

    public MenuEventManager addEventListener(Menu menu, Runnable handler) {
        this.validate(menu, handler);
        this.handlerMap.put(menu, handler);
        return this;
    }

    private void validate(Menu menu, Runnable runnable) {
        if (menu == null) {
            throw new IllegalArgumentException(NOT_RECEIVED_MENU_MESSAGE);
        }
        if (runnable == null) {
            throw new IllegalArgumentException(NOT_RECEIVED_HANDLER_MESSAGE);
        }
    }

    public void removeEventListener(Menu menu) {
        this.handlerMap.remove(menu);
    }

    public void removeAllEventListener() {
        this.handlerMap.clear();
    }

    Optional<Runnable> select(Menu menu) {
        return Optional.ofNullable(this.handlerMap.get(menu));
    }
}
