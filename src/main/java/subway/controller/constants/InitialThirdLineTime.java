package subway.controller.constants;

public enum InitialThirdLineTime {
    ONE("교대역", "남부터미널",2),
    TWO("남부터미널", "양재역",5),
    THREE("양재역", "매봉역", 1);

    private final String departureName;
    private final String terminalName;
    private final int time;

    private InitialThirdLineTime(String departureName, String terminalName, int time) {
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
