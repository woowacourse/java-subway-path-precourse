package subway.Initialization;

public enum LineInitialization {
    LINE_TWO("2호선"),
    LINE_THREE("3호선"),
    SINBUNDANG_LINE("신분당선");

    private String name;

    LineInitialization(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
