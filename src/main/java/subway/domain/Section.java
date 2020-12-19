package subway.domain;

import java.util.List;

public class Section {
    private String departureStation;
    private String arrivalStation;
    private Cost cost;

    public Section(String departureStation, String arrivalStation, Cost cost) {
        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;
        this.cost = cost;
    }
}
