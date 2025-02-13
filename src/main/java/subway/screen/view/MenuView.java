package subway.screen.view;

import java.util.List;

import subway.screen.ui.Console;

public abstract class MenuView implements View {
    private static final String NOT_RECEIVED_EVENT_MANAGER_MESSAGE = "이벤트 관리자를 전달받지 못하였습니다.";
    private static final String MENU_OUTPUT_FORMAT = "%s. %s";
    private static final String CAN_NOT_SELECTED_FUNCTION_MESSAGE = "선택할 수 없는 기능입니다.";
    private static final String CAN_NOT_PROCESS_EVENT_HANDLER_MESSAGE = "이벤트를 처리할 수 없습니다.";

    private final MenuEventManager menuEventManager;

    protected MenuView() {
        this(MenuEventManager.builder());
    }

    protected MenuView(MenuEventManager menuEventManager) {
        if (menuEventManager == null) {
            throw new IllegalArgumentException(NOT_RECEIVED_EVENT_MANAGER_MESSAGE);
        }
        this.menuEventManager = menuEventManager;
    }

    protected abstract Class<? extends Menu> getType();

    @Override
    public void show() {
        Console.printHeader(this.title());
        List<Menu> menuList = Menu.findAll(this.getType());
        for (Menu menu : menuList) {
            Console.println(String.format(MENU_OUTPUT_FORMAT, menu.getCommand(), menu.getName()));
        }
        Console.println();
    }

    public Menu question() {
        do {
            Console.printHeader("원하는 기능을 선택하세요.");
            String command = Console.readline();
            try {
                Menu menu = Menu.findByCommand(this.getType(), command)
                    .orElseThrow(() -> new IllegalArgumentException(CAN_NOT_SELECTED_FUNCTION_MESSAGE));
                Console.println();
                return menu;
            } catch (IllegalArgumentException e) {
                Console.println();
                Console.printError(e.getMessage());
                Console.println();
            }
        } while (true);
    }

    public void onEvent(Menu menu) {
        Runnable handler = this.menuEventManager.select(menu)
            .orElseThrow(() -> new IllegalArgumentException(CAN_NOT_PROCESS_EVENT_HANDLER_MESSAGE));
        handler.run();
    }
}
