package subway.domain.selector.menu;

import java.util.LinkedHashMap;
import subway.domain.selector.BackWardItem;
import subway.domain.selector.MinimumTimePathItem;
import subway.domain.selector.QuitItem;
import subway.domain.selector.ShortestPathFindItem;

public class MenuRepository {

    private static final LinkedHashMap<String, Menu> menus = new LinkedHashMap<>();

    static {
        Menu pathCriteriaMenu = new Menu("1", "경로 조회");
        pathCriteriaMenu.addMenuItems("1", new ShortestPathFindItem("1", "최단 거리"));
        pathCriteriaMenu.addMenuItems("2", new MinimumTimePathItem("2", "최소 시간"));
        pathCriteriaMenu.addMenuItems("B", new BackWardItem("B", "돌아가기"));
        menus.put("1", pathCriteriaMenu);

        Menu mainMenu = new Menu("0", "메인");
        mainMenu.addMenus("1", pathCriteriaMenu);
        mainMenu.addMenuItems("Q", new QuitItem("Q", "종료"));
        menus.put("0", mainMenu);
    }

    public static LinkedHashMap<String, Menu> menus() {
        return menus;
    }
}
