package subway.domain;

public class Edge {
    private Station afterStation;
    private int distance;
    private int time;

    public Edge(Station afterStation, int distance, int time) {
        this.afterStation = afterStation;
        this.distance = distance;
        this.time = time;
    }
}
