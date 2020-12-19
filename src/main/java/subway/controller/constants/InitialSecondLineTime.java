package subway.controller.constants;

public enum InitialSecondLineTime {
    ONE("교대역", "강남역",3),
    TWO("강남역", "역삼역",3);

    private final String departureName;
    private final String terminalName;
    private final int time;

    private InitialSecondLineTime(String departureName, String terminalName, int time) {
        this.departureName = departureName;
        this.terminalName = terminalName;
        this.time = time;
    }

    public String getDepartureName() {
        return departureName;
    }

    public String getTerminalName() {
        return terminalName;
    }

    public int getTime() {
        return time;
    }
}
