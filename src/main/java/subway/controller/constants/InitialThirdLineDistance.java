package subway.controller.constants;

public enum InitialThirdLineDistance {
    ONE("교대역", "남부터미널",3),
    TWO("남부터미널", "양재역",6),
    THREE("양재역", "매봉역", 1);

    private final String departureName;
    private final String terminalName;
    private final int distance;

    private InitialThirdLineDistance(String departureName, String terminalName, int distance) {
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
