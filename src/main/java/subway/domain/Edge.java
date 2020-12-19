package subway.domain;

public class Edge {

    private int distance;
    private int time;
    private final String distanceUnit = "km";
    private final String timeUnit = "분";

    public Edge(int distance, int time) {
        this.distance = distance;
        this.time = time;
    }
}
