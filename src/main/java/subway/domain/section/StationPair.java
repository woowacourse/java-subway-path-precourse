package subway.domain.section;

import subway.domain.station.Station;

import java.util.Objects;

public class StationPair {
    private Station from;
    private Station to;

    public StationPair(Station from, Station to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(from.getName() + to.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof StationPair) {
            return this.from == ((StationPair) o).from && this.to == ((StationPair) o).to;
        }

        return false;
    }
}
