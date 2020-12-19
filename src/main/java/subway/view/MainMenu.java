package subway.view;

import subway.domain.LineRepository;

import java.util.Arrays;
import java.util.function.Supplier;

public enum MainMenu {
    SHOW_SUBWAY_PATH("1", "경로 조회", () -> SubwayPathConsole.selectMenu()),
    QUIT("Q", "종료");

    private String key;
    private String menuList;
    private Supplier<Boolean> next;

    MainMenu(String key, String menuList) {
        this.key = key;
        this.menuList = menuList;
    }

    MainMenu(String key, String menuList, Supplier<Boolean> next) {
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

    public void moveNext(String key) {
        next.get();
    }

    public static MainMenu moveByKey(String key) {
        return Arrays.stream(values())
                .filter(menu -> menu.getKey().equals(key))
                .findAny().get();
    }
}
