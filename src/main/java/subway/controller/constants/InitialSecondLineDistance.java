package subway.controller.constants;

public enum InitialSecondLineDistance {
    ONE("교대역", "강남역",2),
    TWO("강남역", "역삼역",2);

    private final String departureName;
    private final String terminalName;
    private final int distance;

    private InitialSecondLineDistance(String departureName, String terminalName, int distance) {
        this.departureName = departureName;
        this.terminalName = terminalName;
        this.distance = distance;
    }

    public String getDepartureName() {
        return departureName;
    }

    public String getTerminalName() {
        return terminalName;
    }

    public int getDistance() {
        return distance;
    }
}
