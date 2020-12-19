package subway.exception.constant;

public enum TraverseInputEnum {
    SHORTEST_DISTANCE("1"),
    SHORTEST_TIME("2"),
    BACK("B");

    private String option;

    TraverseInputEnum(String option) {
        this.option = option;
    }

    public String getOption() {
        return this.option;
    }
}
