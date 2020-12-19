package subway.domain;

public class Edge {
    private String from;
    private String to;
    private int distance;
    private int time;

    public Edge(String from, String to, int distance, int time) {
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