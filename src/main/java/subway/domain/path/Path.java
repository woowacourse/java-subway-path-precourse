package subway.domain.path;

import subway.domain.line.Line;
import subway.domain.station.Station;

public class Path {
    private final Station source;
    private final Station dest;
    private final Line line;
    private final int distance;
    private final int time;

    public Path(Station source, Station dest, Line line, int distance, int time) {
        this.source = source;
        this.dest = dest;
        this.line = line;
        this.distance = distance;
        this.time = time;
    }

    public Station getSource() {
        return source;
    }

    public Station getDest() {
        return dest;
    }

    public int getTime() {
        return time;
    }

    public int getDistance() {
        return distance;
    }
}
