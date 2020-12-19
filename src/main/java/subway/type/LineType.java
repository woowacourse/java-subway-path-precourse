package subway.type;

public enum LineType {
    TWO("2호선"),
    THREE("3호선"),
    SHINBUNDANG("신분당선");

    private final String line;

    LineType(String line) {
        this.line = line;
    }

    public String getLine() {
        return line;
    }
}
