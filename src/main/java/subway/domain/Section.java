package subway.domain;

import java.util.Iterator;
import java.util.Set;

public class Section {
    private static final String FORMAT = "%s - %s, 거리: %d, 시간: %d";

    private Set<Station> stations;
    private final int time;
    private final int distance;

    public Section(Set<Station> stations, int distance, int time) {
        this.stations = stations;
        this.distance = distance;
        this.time = time;
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

    @Override
    public String toString() {  //테스트를 위한 목적이 강합니다.
        Iterator<Station> iterator = stations.iterator();
        return String.format(FORMAT, iterator.next().getName(), iterator.next().getName(), this.distance, this.time);
    }
}
