package subway.legacy;

public enum Lines {

    LINE_2("2호선"),
    LINE_3("3호선"),
    LINE_SHINBUNDANG("신분당선");

    private String name;
    Lines(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
