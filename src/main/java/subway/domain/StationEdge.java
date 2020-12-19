package subway.domain;

public class StationEdge {
    private String from;
    private String to;
    private int distance;
    private int time;

    public StationEdge(String from, String to, int distance, int time) {
        this.from = from;
        this.to = to;
        this.distance = distance;
        this.time = time;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public int getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }
}
