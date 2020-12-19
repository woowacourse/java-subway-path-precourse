package subway.exception.constant;

public enum MainInputEnum {
    TRAVERSE_SUBWAY("1"),
    QUIT("Q");

    private String option;

    MainInputEnum(String option) {
        this.option = option;
    }

    public String getOption() {
        return this.option;
    }
}
