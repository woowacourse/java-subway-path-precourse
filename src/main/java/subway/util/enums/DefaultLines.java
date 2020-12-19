package subway.util.enums;

public enum DefaultLines {
    LINE2("2호선"),
    LINE3("3호선"),
    SINBUNDANG_LINE("신분당선");

    private String name;

    private DefaultLines(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
