package subway.view;

public class ErrorMessage {

    private static final String LABEL = "[ERROR] ";

    public static final String DECISION_WRONG = LABEL + "선택할 수 없는 기능입니다.";

    public static final String STATION_NONE = LABEL + "역이 존재하지 않습니다.";
    public static final String STATION_DUPLICATE = LABEL + "출발역과 도착역이 동일합니다.";

    public static final String LINE_NONE = LABEL + "노선이 존재하지 않습니다.";

    public static final String CONNECTION_NONE = LABEL + "두 역이 연결되어 있지 않습니다";
}
