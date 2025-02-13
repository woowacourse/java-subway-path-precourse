package subway.domain.section;

import subway.domain.line.Line;
import subway.domain.station.Station;

public class Section {
    private final Line line;
    private final Station source;
    private final Station sink;
    private final int distance;
    private final int time;

    public Section(Line line, Station source, Station sink, int distance, int time) {
        this.line = line;
        this.source = source;
        this.sink = sink;
        this.distance = distance;
        this.time = time;
    }

    public Line getLine() {
        return line;
    }

    public Station getSource() {
        return source;
    }

    public Station getSink() {
        return sink;
    }

    public int getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }
}
