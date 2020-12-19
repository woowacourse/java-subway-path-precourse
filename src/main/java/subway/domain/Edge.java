package subway.domain;

public class Edge {
    private Station destination;
    private int distance;
    private int time;

    public Edge(Station destination, int distance, int time) {
        this.destination = destination;
        this.distance = distance;
        this.time = time;
    }

    public Station getDestination() {
        return destination;
    }

    public String toString() {
        return destination.getName() + " " + distance + "km, " + time + "분";
    }
}
