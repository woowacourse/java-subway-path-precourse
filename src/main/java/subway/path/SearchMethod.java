package subway.path;

public enum SearchMethod {
    DISTANCE("1", "최단 거리"),
    TIME("2", "최소 시간");

    private String value;
    private String description;

    SearchMethod(String value, String description) {
        this.value = value;
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}
