package subway.domain;

public class Section {
    private static final String DISTANCE_UNIT = "km";
    private static final String TIME_UNIT = "분";

    private Station startStation;
    private Station endStation;
    private int distance;
    private int time;

    public Section(Station startStation, Station endStation, int distance, int time) {
        this.startStation = startStation;
        this.endStation = endStation;
        this.distance = distance;
        this.time = time;
    }

    public boolean isStartStation(Station startStation) {
        return  this.startStation.equals(startStation);
    }
}
