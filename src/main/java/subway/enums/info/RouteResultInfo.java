package subway.enums.info;

public enum RouteResultInfo {
    INFO("[INFO] "),
    TITLE("## 조회 결과"),
    DELIMITER(INFO.getValue() + "---"),
    TOTAL_DISTANCE(INFO.getValue() + "총 거리: "),
    KM("km"),
    TOTAL_TIME(INFO.getValue() + "총 소요 시간: "),
    MIN("분");

    private String value;

    RouteResultInfo(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
