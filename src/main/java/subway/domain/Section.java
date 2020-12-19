package subway.domain;

import java.util.Set;

public class Section {
    private Set<Station> stations;
    private final int time;
    private final int distance;

    public Section(Set<Station> stations, int time, int distance) {
        this.stations = stations;
        this.time = time;
        this.distance = distance;
    }

    public int getTime() {
        return this.time;
    }

    public int getDistance() {
        return this.distance;
    }

    @Override
    public int hashCode() {
        return this.stations.hashCode();
    }
}
