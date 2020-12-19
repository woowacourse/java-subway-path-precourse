package subway.type;

public enum InputType {
    ONE("1"),
    TWO("2"),

    QUITTING("Q"),
    BACK("B");

    private final String input;

    InputType(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }
}
