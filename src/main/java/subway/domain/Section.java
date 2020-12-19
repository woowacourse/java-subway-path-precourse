package subway.domain;

public class Section {
    private static final String DISTANCE_UNIT = "km";
    private static final String TIME_UNIT = "분";

    private final Station start;
    private final Station end;
    private final long distance;
    private final long time;

    public Section(Station start, Station end, long distance, long time) {
        this.start = start;
        this.end = end;
        this.distance = distance;
        this.time = time;
    }

    public Station getStart() {
        return start;
    }

    public Station getEnd() {
        return end;
    }

    public long getDistance() {
        return distance;
    }

    public long getTime() {
        return time;
    }
}
