package resource;

public class TextResource {
    public static final String PREFIX_ERROR = "\n[ERROR]";
    public static final String PREFIX_INFO = "[INFO]";

    public static final String ERROR_STATION_NAME_DUPLICATED = PREFIX_ERROR
            + "이미 해당 지하철역이 존재 합니다. 등록 할 수 없습니다.";

    public static final String ERROR_NOT_EXISTENCE_STATION = PREFIX_ERROR
            + "해당 역이 존재 하지 않습니다.";

    public static final String ERROR_NOT_EXISTENCE_LINE = PREFIX_ERROR
            + "해당 노선이 존재 하지 않습니다.";

    public static final String ERROR_START_END_STATION_DUPLICATED = PREFIX_ERROR
            + "상행 종점역과 하행 종점역이 같을 수 없습니다.";

    public static final String ERROR_STATION_DUPLICATED_IN_SECTION = PREFIX_ERROR
            + "해당 노선의 구간에 입력한 역이 이미 존재 합니다.";

    public static final String ERROR_ORDER_NOT_VALID = PREFIX_ERROR
            + "입력한 순서가 올바르지 않습니다.";

    public static final String ERROR_DISTANCE_TIME_NOT_POSITIVE = PREFIX_ERROR
            + "거리와 소요시간은 음수 일 수 없습니다.";

    public static final String ERROR_PATH_SIZE_OVER = PREFIX_ERROR
            + "구간의 개수가 너무 많습니다.";

    public static final String ERROR_START_END_STATION_SAME = PREFIX_ERROR
            + "출발역과 도착역이 동일합니다.\n";


    public static String HEADER_MAIN_VIEW = "\n## 메인 화면";
    public static String HEADER_ROUTE_SHOWING = "\n## 경로 기준";
    public static String HEADER_ROUTE_RESULT = "\n## 조회결과";


    public static String TOTAL_DISTANCE = "총 거리: ";
    public static String TOTAL_TIME = "총 소요 시간: ";

    public static String UNIT_KM = "KM";
    public static String UNIT_MIN = "분";

    public static String FUNCTION_QUIT = "종료";
    public static String FUNCTION_BACK = "돌아가기";

    public static String ASK_FUNCTION = "\n## 원하는 기능을 선택하세요.";
    public static String ASK_START_STATION = "\n## 출발역을 입력하세요.";
    public static String ASK_END_STATION = "\n## 도착역을 입력하세요.";

    public static String FUNCTION_ROUTE_SHOWING = "경로 조회";
    public static String FUNCTION_MIN_DISTANCE = "최단 거리";
    public static String FUNCTION_MIN_TIME = "최소 시간";
    public static final String ERROR_INVALID_FUNCTION = PREFIX_ERROR
            + "선택할 수 없는 기능입니다.";
}
