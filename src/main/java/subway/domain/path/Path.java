package subway.domain.path;

import subway.domain.line.Line;
import subway.domain.station.Station;

public class Path {
    private final Station prevStation;
    private final Station nextStation;
    private final Line line;
    private final int distance;
    private final int time;

    public Path(Station prevStation, Station nextStation, Line line, int distance, int time) {
        this.prevStation = prevStation;
        this.nextStation = nextStation;
        this.line = line;
        this.distance = distance;
        this.time = time;
    }
}
