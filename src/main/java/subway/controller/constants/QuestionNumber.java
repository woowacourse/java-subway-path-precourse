package subway.controller.constants;

public enum QuestionNumber {
    ONE("1"),
    TWO("2"),
    BACK("B"),
    TERMINATE("Q");

    private String option;

    private QuestionNumber(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }
}
