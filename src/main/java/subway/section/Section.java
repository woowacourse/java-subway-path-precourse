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
}
