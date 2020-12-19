package subway.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Constant {
    static final String[] mainMenuItems = {"1. 경로 조회", "Q. 종료"};
    static final String[] routeSelectItems = {"1. 최단 거리", "2. 최소 시간", "B. 돌이가기"};

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

    public static final String ONE = "1";
    public static final String TWO = "2";
    public static final String Q = "Q";
    public static final String B = "B";

    static final String CHOOSE_FUNCTION = "원하는 기능을 선택하세요.";
    public static final String MAIN_MENU_TITLE = "메인 화면";
    public static final String ROUTE_SELECT_MENU_TITLE = "경로 기준";

    static final String IS_IN_MENU = "존재하지 않는 항목입니다.";
    static final String STATION_NOT_EXIST = "존재하지 않는 역입니다.";
    static final String STATION_NOT_EXIST_IN_LINE = "해당 노선에 존재하지 않는 역입니다.";

    static final String[] defaultStations = {"교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"};
    static final String[] defaultLines = {"2호선", "3호선", "신분당선"};
    static final String[][] defaultSetting = {
            {defaultStations[0], defaultStations[1], defaultStations[2]},
            {defaultStations[0], defaultStations[3], defaultStations[4], defaultStations[6]},
            {defaultStations[1], defaultStations[4], defaultStations[5]}
    };

    private static final List<String> defaultStationList = Arrays.asList(defaultStations);
    private static final List<String> defaultLineList = Arrays.asList(defaultLines);
    private static final List<String[]> defaultSettingList = Arrays.asList(defaultSetting);

    public static List<String> defaultStationList() {
        return Collections.unmodifiableList(defaultStationList);
    }

    public static List<String> defaultLineList() {
        return Collections.unmodifiableList(defaultLineList);
    }

    public static List<String[]> defaultSettingList() {
        return Collections.unmodifiableList(defaultSettingList);
    }

    public static final int[][] defaultTime = {
            {3, 3},
            {2, 5, 1},
            {8, 3}
    };

    public static final int[][] defaultDistance = {
            {2, 2},
            {3, 6, 1},
            {2, 10}
    };
}
