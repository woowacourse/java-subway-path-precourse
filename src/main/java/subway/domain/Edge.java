package subway.domain;

public class Edge {
    private Station nextStation;
    private int distance;
    private int time;

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

    public String getStationName() {
        return nextStation.getName();
    }
}
