package resource;

public class TextResource {
    public static final String PREFIX_ERROR = "\n[ERROR]";

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

}
