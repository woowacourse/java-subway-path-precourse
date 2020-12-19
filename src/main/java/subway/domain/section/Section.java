package subway.domain.section;

import subway.domain.Station;

public class Section {
    private final Station startStation;
    private final Station arrivalStation;
    private final RunTime runTime;
    private final int distance;

    public Section(Station startStation, Station arrivalStation, RunTime runTime, int distance) {
        this.startStation = startStation;
        this.arrivalStation = arrivalStation;
        this.runTime = runTime;
        this.distance = distance;
    }

    public Section(Station startStation, Station arrivalStation, int runTime, int distance) {
        this(startStation,arrivalStation, new RunTime(runTime), distance);
    }
}
