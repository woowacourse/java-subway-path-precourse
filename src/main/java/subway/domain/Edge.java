package subway.domain;

public class Edge {
    private final Station nextStation;
    private final int distance;
    private final int time;

    public Edge(Station nextStation, int distance, int time) {
        this.nextStation = nextStation;
        this.distance = distance;
        this.time = time;
    }

    public boolean isNextStation(Station station) {
        return nextStation.equals(station);
    }

    public int getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }
}
