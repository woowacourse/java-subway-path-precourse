package subway.view;

import subway.controller.SubwayPathController;

import java.util.Arrays;
import java.util.function.Supplier;

public enum SubwayPathMenu {
    REGISTER_STATION("1", "최단 거리", () -> SubwayPathController.getInstance().printByMinDistance()),
    DELETE_STATION("2", "최소 시간", () -> SubwayPathController.getInstance().printByMinTime()),
    BACK("B", "돌아가기", () -> SubwayPathController.getInstance().back());

    private String key;
    private String menuList;
    private Supplier<Boolean> next;

    SubwayPathMenu(String key, String menuList) {
        this.key = key;
        this.menuList = menuList;
    }

    SubwayPathMenu(String key, String menuList, Supplier<Boolean> next) {
        this.key = key;
        this.menuList = menuList;
        this.next = next;
    }

    public static boolean isValidKey(String input) {
        return Arrays.stream(values()).anyMatch(menu -> menu.getKey().equals(input));
    }

    public String getKey() {
        return key;
    }

    public String getMenuList() {
        return menuList;
    }

    public boolean moveNext() {
        return next.get();
    }

    public static SubwayPathMenu moveByKey(String key) {
        return Arrays.stream(values())
                .filter(menu -> menu.getKey().equals(key))
                .findAny().get();
    }
}
