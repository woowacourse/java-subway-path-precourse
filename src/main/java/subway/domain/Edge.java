package subway.domain;

public class Edge {

    public int distance;
    public int time;
    public final String distanceUnit = "km";
    public final String timeUnit = "분";

    public Edge(int distance, int time) {
        this.distance = distance;
        this.time = time;
    }
}
