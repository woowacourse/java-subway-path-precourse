package subway;

public enum PathCriteriaSelection {
    SHORTEST_DISTANCE("1"),
    MINIMUM_TIME("2"),
    GO_BACK("3");

    private final String strValue;

    PathCriteriaSelection(String userSelectionInput) {
        this.strValue = userSelectionInput;
    }

    public String getStrValue() {
        return strValue;
    }
}
