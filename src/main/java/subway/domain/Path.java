package subway.domain;

import java.util.Arrays;
import java.util.List;

public class Path {
    private static final int START = 0;
    private static final int END = 1;

    private List<Station> stations;
    private int time;
    private int distance;

    public Path(Station start, Station end, int time, int distance) {
        this.stations = Arrays.asList(start, end);
        this.time = time;
        this.distance = distance;
    }

    public Station getStartStation() {
        return stations.get(START);
    }

    public Station getEndStation() {
        return stations.get(END);
    }

    public int getTime() {
        return time;
    }

    public int getDistance() {
        return distance;
    }
}
