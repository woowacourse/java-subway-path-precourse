package subway;

public enum MainSelection {
    FIND_PATH("1"),
    QUIT("Q");

    private final String strValue;

    MainSelection(String userSelection) {
        this.strValue = userSelection;
    }

    public String getStrValue() {
        return strValue;
    }
}
