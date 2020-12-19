package subway.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Constant {
    static final String[] mainMenuItems = {"1. 경로 조회", "Q. 종료"};
    static final String[] routeSelectItems = {"1. 최단 거리", "2. 최소 시간", "Q. 종료"};

    private static final List<String> mainMenuItemList = Arrays.asList(mainMenuItems);
    private static final List<String> routeSelectItemList = Arrays.asList(routeSelectItems);

    public static List<String> mainMenuItemList() {
        return Collections.unmodifiableList(mainMenuItemList);
    }

    public static List<String> routeSelectItemList() {
        return Collections.unmodifiableList(routeSelectItemList);
    }

    static final String HEAD_HASH = "## ";
    static final String HEAD_INFO = "[INFO] ";
    static final String HEAD_ERROR = "[ERROR] ";
    static final String DIVIDER = "---";

    static final String CHOOSE_FUNCTION = "원하는 기능을 선택하세요.";
    public static final String MAIN_MENU_TITLE = "메인 화면";

    static final String IS_IN_MENU = "존재하지 않는 항목입니다.";
}
