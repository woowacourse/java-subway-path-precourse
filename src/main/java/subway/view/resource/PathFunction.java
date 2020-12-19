package subway.view.resource;

public enum PathFunction {
    SHORTEST_PATH("1"),
    MINIMUM_TIME("2"),
    BACK("B");

    private String index;

    PathFunction(String index) {
        this.index = index;
    }

    public String getIndex() {
        return index;
    }
}
