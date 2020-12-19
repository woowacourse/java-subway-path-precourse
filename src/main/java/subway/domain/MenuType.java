package subway.domain;

import java.util.Arrays;
import java.util.List;

public enum MenuType {
    MAIN_MENU_RANGE(Arrays.asList("1","2","Q")),
    MAIN_SEARCH_PATH("1"),
    MAIN_EXIT("Q"),
    SEARCH_PATH_MENU_RANGE(Arrays.asList("1","2","B")),
    SEARCH_SHORTEST_PATH("1"),
    SEARCH_SHORTEST_TIME("2"),
    BACK("B");

    private String key;
    private List<String> keys;

    private MenuType(String key) {
        this.key = key;
    }

    private MenuType(List<String> keys) {
        this.keys = keys;
    }

    public void validateMenuRange(String menu) {
        boolean isContains = this.keys.contains(menu);
        if (!isContains) {
            throw new IllegalArgumentException("[ERROR] 선택할 수 없는 기능입니다.");
        }
    }
}