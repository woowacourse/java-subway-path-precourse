package subway.domain.menu;

import java.util.HashMap;
import java.util.Map;

import subway.controller.MenuController;

public class MenuRepository {
    private static final Map<MenuType, Menu> menus = new HashMap<>();

    private static final String MAIN = "메인 화면";
    private static final String PATH = "경로 기준";

    private static final String SEARCH_PATH = "경로 조회";
    private static final String SHORTEST_DISTANCE = "최단 거리";
    private static final String SHORTEST_TIME = "최소 시간";

    private static final String QUIT = "종료";
    private static final String BACK = "돌아가기";
    
    private static final String KEY_ONE = "1";
    private static final String KEY_TWO = "2";
    private static final String KEY_QUIT = "Q";
    private static final String KEY_BACK = "B";

    static {
        setMainMenu();
        setSelectWeightMenu();
    }

    public static Menu getMenu(MenuType menuType) {
        return menus.get(menuType);
    }

    private static void setMainMenu() {
        Menu menu = Menu.createWithMenuItems(
            MAIN,
            new MenuItem(KEY_ONE, SEARCH_PATH, MenuController::callSearchPathMenu),
            new MenuItem(KEY_QUIT, QUIT, null));

        menus.put(MenuType.MAIN, menu);
    }

    private static void setSelectWeightMenu() {
        Menu menu = Menu.createWithMenuItems(
            PATH,
            new MenuItem(KEY_ONE, SHORTEST_DISTANCE, null),
            new MenuItem(KEY_TWO, SHORTEST_TIME, null),
            new MenuItem(KEY_BACK, BACK, null));

        menus.put(MenuType.SEARCH_PATH, menu);
    }
}
