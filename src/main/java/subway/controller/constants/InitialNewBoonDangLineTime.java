package subway.controller.constants;

public enum InitialNewBoonDangLineTime {
    ONE("강남역", "양재역",8),
    TWO("양재역", "양재시민의숲역",3);

    private final String departureName;
    private final String terminalName;
    private final int time;

    private InitialNewBoonDangLineTime(String departureName, String terminalName, int time) {
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
