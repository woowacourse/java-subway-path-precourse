package subway.domain;

import java.util.HashSet;
import java.util.Set;

public class UnitPath {
    private final Set<Station> stations;

    //todo 아래 두 값 래핑
    private final int time;
    private final int distance;

    public UnitPath(Station source, Station target, int time, int distance) {
        this.stations = new HashSet<>();
        stations.add(source);
        stations.add(target);
        this.time = time;
        this.distance = distance;
    }

    public boolean isPathOf(Station source, Station target) {
        if(source == target){
            //todo
            throw new IllegalArgumentException("출발 끝 같음");
        }

        return this.stations.contains(source) && this.stations.contains(target);
    }
}
