package subway.domain.section;

import java.util.ArrayList;
import java.util.List;
import subway.domain.station.Station;

public class Section {
    private static final int MIN_DISTANCE = 1;
    private static final int MIN_TIME = 1;
    private List<Station> stations;
    private int distance;
    private int time; // 단위 : 분

    public Section(int distance, int time, List<Station> stations) {
        validateDistance(distance);
        validateTime(time);
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

    public void validateDistance(int distance) {
        if (distance < MIN_DISTANCE) {
            throw new IllegalArgumentException("[ERROR] 거리는 양의 정수여야 합니다.");
        }
    }

    public void validateTime(int time) {
        if (time < MIN_TIME) {
            throw new IllegalArgumentException("[ERROR] 시간은 양의 정수여야 합니다.");
        }
    }
}
