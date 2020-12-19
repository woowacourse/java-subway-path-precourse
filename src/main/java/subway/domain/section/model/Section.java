package subway.domain.section.model;

import subway.station.model.Station;

public class Section {
    private final Station startStation;
    private final Station arrivalStation;
    private final RunTime runTime;
    private final Distance distance;

    public Section(Station startStation, Station arrivalStation, RunTime runTime, Distance distance) {
        this.startStation = startStation;
        this.arrivalStation = arrivalStation;
        this.runTime = runTime;
        this.distance = distance;
    }

    public Section(Station startStation, Station arrivalStation, int runTime, int distance) {
        this(startStation, arrivalStation, new RunTime(runTime), new Distance(distance));
    }
}
