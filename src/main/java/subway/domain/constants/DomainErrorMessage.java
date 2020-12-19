package subway.domain.constants;

public class DomainErrorMessage {
    public static final String LINE_FORMAT = "[ERROR] 노선의 이름은 선으로 끝나야 합니다.";
    public static final String SAME_STATION = "[ERROR] 출발역과 도착역이 동일합니다.";
    public static final String STATION_FORMAT = "[ERROR] 역의 이름은 역으로 끝나야합니다.";
    public static final String OVERLAP_LINE = "[ERROR] 이미 등록된 노선입니다.";
    public static final String OVERLAP_STATION = "[ERROR] 이미 등록된 역입니다.";
}
