package subway.domain.station;

public class Path {
    private final Station nextStation;
    private final int distance;
    private final int time;

    public Path(Station nextStation, int distance, int time) {
        this.nextStation = nextStation;
        this.distance = distance;
        this.time = time;
    }
}
