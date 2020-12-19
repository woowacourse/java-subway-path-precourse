package subway.util;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import subway.model.MenuGroup.Menu;
import subway.model.MenuGroup.MenuItem;

public class Constants {

    public final static List<MenuItem> MAIN_MENU_ITEMS = Arrays.asList(
        new MenuItem("1", "경로 조회"),
        new MenuItem("Q", "종료")
    );

    public final static List<MenuItem> INQUIRY_MENU_ITEMS = Arrays.asList(
        new MenuItem("1", "최단 거리"),
        new MenuItem("2", "최소 시간"),
        new MenuItem("B", "돌아가기")
    );


    public final static Map<String, Menu> MENU_GROUPS = Map.of(
        Constants.MAIN_MENU_STATE, new Menu("메인 화면", Constants.MAIN_MENU_ITEMS),
        Constants.INQUIRY_MENU_STATE, new Menu("경로 기준", Constants.INQUIRY_MENU_ITEMS)
    );

    public static final String MENU_GROUP_PREFIX = "## ";

    public static final String MAIN_MENU_STATE = "MAIN";
    public static final String INQUIRY_MENU_STATE = "INQUIRY";

    public final static String EXIT_INPUT_CHARACTER = new String("Q");
    public final static String BACKWARD_INPUT_CHARACTER = new String("B");

    public final static int MIN_NAME_STRING_LENGTH_INT = 2;
    public final static int MIN_SECTION_LENGTH_INT = 2;
    public final static int INDEX_ARRANGE_INT = 1;

    public final static String PREFIX_INFO = "[INFO] ";
    public final static String PREFIX_ERROR = "[ERROR] ";

    public final static String INVALID_ASK = "선택할 수 없는 기능입니다.";
    public final static String INVALID_STRING = "잘못된 문자 입력입니다.";

    public final static String ASK_FEATURE_SELECT_ANNOUNCEMENT = "## 원하는 기능을 선택하세요.";

    public final static String INQUIRY_START_STATION_ASK = "## 출발역을 입력하세요";
    public final static String INQUIRY_END_STATION_ASK = "## 도착역을 입력하세요";
    public final static String INQUIRY_RESULT = "## 조회 결과";
    public final static String INQUIRY_DISTANCE = "총 거리: ";
    public final static String INQUIRY_DISTANCE_UNIT = "km";
    public final static String INQUIRY_TIME = "총 소요 시간: ";
    public final static String INQUIRY_TIME_UNIT = "분";


    public static final String INVALID_START_TO_END_STATION = "출발역과 도착역이 동일합니다.";

    public final static String SEPARATE_STRING_INQUIRY = "---";
}
