package subway.view;

import java.util.HashMap;
import java.util.Map;

public class MenuSelectionValidator {
    private static final String MAIN_MENU = "Main";
    private static final String MAIN_MENU_FORMAT_REGEX = "1|Q";
    private static final String ROUTE_MENU = "Route";
    private static final String ROUTE_MENU_FORMAT_REGEX = "1|2|B";

    private Map<String, String> menuFormat;

    public MenuSelectionValidator() {
        menuFormat = new HashMap<>();
        menuFormat.put(MAIN_MENU, MAIN_MENU_FORMAT_REGEX);
        menuFormat.put(ROUTE_MENU, ROUTE_MENU_FORMAT_REGEX);
    }

    public void validateSelection(String menu, String selection) {
        String format = menuFormat.get(menu);
        if (!isSelectionMatchingFormat(selection, format)) {
            throw new IllegalArgumentException("[ERROR] 선택할 수 없는 기능입니다.\n");
        }
    }

    private boolean isSelectionMatchingFormat(String selection, String format) {
        return selection.matches(format);
    }
}
