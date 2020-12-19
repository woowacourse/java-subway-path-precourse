package subway.domain.menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Menu {
    MAIN(Arrays.asList("\n## 메인 화면", "1. 경로조회", "Q. 종료"),
        Arrays.asList(MenuKeys.ONE, MenuKeys.EXIT)),
    SEARCH_PATH(Arrays.asList("\n## 경로 기준", "1. 최단 거리", "2. 최소 시간", "B. 돌아가기"),
        Arrays.asList(MenuKeys.ONE, MenuKeys.TWO, MenuKeys.BACK));

    private final List<String> menuItems;
    private final List<MenuKeys> menuKeys;

    Menu(List<String> menuItems, List<MenuKeys> menuKeys) {
        this.menuItems = menuItems;
        this.menuKeys = menuKeys;
    }

    public List<String> getMenuItems() {
        return menuItems;
    }

    public String getStringMenuKeys() {
        List<String> keys = new ArrayList<>();
        for (MenuKeys key : menuKeys) {
            keys.add(key.getKey());
        }
        return keys.toString();
    }

    public boolean containsKey(String inputKey) {
        for (MenuKeys key : menuKeys) {
            if (key.getKey().equals(inputKey)) {
                return true;
            }
        }
        return false;
    }

}
