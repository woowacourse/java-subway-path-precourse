package subway.domain.section;

import java.util.ArrayList;
import java.util.List;
import subway.domain.station.Station;

public class Section {

    List<Station> stations;
    private int distance;
    private int time; // 단위 : 분

    public Section(int distance, int time, List<Station> stations) {
        this.distance = distance;
        this.time = time;
        this.stations = new ArrayList<>(stations);
    }

    public int getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }

    public boolean contains(Station station, Station otherStation) {
        return stations.contains(station) && stations.contains(otherStation);
    }
}
