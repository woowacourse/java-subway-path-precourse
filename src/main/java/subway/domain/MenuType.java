package subway.domain;

import java.util.Arrays;
import java.util.List;

public enum  MenuType {
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
}