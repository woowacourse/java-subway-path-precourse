package subway.mainscreen;

public enum MainSelectionType {
    FIND_PATH("1"),
    QUIT("Q"),
    SUCCESS(null);

    private final String strValue;

    MainSelectionType(String userSelection) {
        this.strValue = userSelection;
    }

    public String getStrValue() {
        return strValue;
    }
}
