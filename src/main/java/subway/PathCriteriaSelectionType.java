package subway;

public enum PathCriteriaSelectionType {
    SHORTEST_DISTANCE("1"),
    MINIMUM_TIME("2"),
    GO_BACK("3");

    private final String strValue;

    PathCriteriaSelectionType(String userSelectionInput) {
        this.strValue = userSelectionInput;
    }

    public String getStrValue() {
        return strValue;
    }
}
