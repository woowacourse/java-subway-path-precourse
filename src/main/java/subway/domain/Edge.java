package subway.domain;

public class Edge {
    private Station from;
    private Station to;
    private int distance;
    private int time;

    public Edge(Station from, Station to, int distance, int time) {
        this.from = from;
        this.to = to;
        this.distance = distance;
        this.time = time;
    }

    public Station getFrom() {
        return from;
    }

    Station getTo() {
        return to;
    }

    public int getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }
}
