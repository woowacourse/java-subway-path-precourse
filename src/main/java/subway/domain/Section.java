package subway.domain;

public class Section {
    private Station stationFrom;
    private Station stationTo;
    private int distance;
    private int time;

    public Section(Station stationFrom, Station stationTo, int distance, int time) {
        this.stationFrom = stationFrom;
        this.stationTo = stationTo;
        this.distance = distance;
        this.time = time;
    }

    public Station getStationFrom() {
        return stationFrom;
    }

    public Station getStationTo() {
        return stationTo;
    }

    public int getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }
}
