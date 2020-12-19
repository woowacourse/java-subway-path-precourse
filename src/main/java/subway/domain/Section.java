package subway.domain;

import java.util.List;

public class Section {
    private final String departureStation;
    private final String arrivalStation;
    private final Cost cost;

    public Section(String departureStation, String arrivalStation, Cost cost) {
        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;
        this.cost = cost;
    }

    @Override
    public String toString(){
        return this.departureStation + this.arrivalStation;
    }

    public String getDepartureStation() {
        return this.departureStation;
    }

    public String getArrivalStation() {
        return this.arrivalStation;
    }

    public Cost getCost() {
        return this.cost;
    }
}
