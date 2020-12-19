package subway.common;

public enum MainOption {
    PATH("1", "경로 조회"),
    EXIT("Q", "종료");

    private String value;
    private String description;

    MainOption(String value, String description) {
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
