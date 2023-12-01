package subway.domain;

import java.util.Set;

public class UnitPath {
    private final Station start;
    private final Station end;

    //todo 아래 두 값 래핑
    private final int time;
    private final int distance;

    public UnitPath(Station start, Station end, int time, int distance) {
        this.start = start;
        this.end = end;
        this.time = time;
        this.distance = distance;
    }

    public boolean isPathOf(Station start, Station end) {
        if (this.start.equals(start) && this.end.equals(end)) {
            return true;
        }
        if (this.start.equals(end) && this.end.equals(start)) {
            return true;
        }
        return false;
    }

    public Station getEnd() {
        return end;
    }

    public Station getStart() {
        return start;
    }

    public int getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }
}
