package subway.section;

import subway.cost.Cost;
import subway.station.Station;

public class Section {
    private Station startStation;
    private Station endStation;
    private Cost cost;

    public Section(Station startStation, Station endStation, Cost cost) {
        this.startStation = startStation;
        this.endStation = endStation;
        this.cost = cost;
    }

    public Station getStartStation() {
        return startStation;
    }

    public Station getEndStation() {
        return endStation;
    }

    public int getDistance() {
        return cost.getDistance();
    }

    public int getTime() {
        return cost.getTime();
    }
}
