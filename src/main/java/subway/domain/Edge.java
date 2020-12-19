package subway.domain;

public class Edge {
    private Station to;
    private int distance;
    private int time;

    public Edge(Station to, int distance, int time) {
        this.to = to;
        this.distance = distance;
        this.time = time;
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
