package subway.type;

public enum InformationType {
    INFORMATION("[INFO] "),
    INFORMATION_WITH_LINES("[INFO] ---\n");

    private final String information;

    InformationType(String information) {
        this.information = information;
    }

    public String getInformation() {
        return information;
    }
}
