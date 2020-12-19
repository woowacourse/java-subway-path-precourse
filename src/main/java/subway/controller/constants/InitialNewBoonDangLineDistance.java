package subway.controller.constants;

public enum InitialNewBoonDangLineDistance {
    ONE("강남역", "양재역",2),
    TWO("양재역", "양재시민의숲역",10);

    private final String departureName;
    private final String terminalName;
    private final int distance;

    private InitialNewBoonDangLineDistance(String departureName,
            String terminalName, int distance) {
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
