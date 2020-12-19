package subway.domain;

public class Section {

    private Station station;
    private Station nextStation;
    private int distance;
    private int time;

    public Section(Station station, Station nextStation, int distance, int time) {
        this.station = station;
        this.nextStation = nextStation;
        this.distance = distance;
        this.time = time;
    }

    public Station getStation() {
        return this.station;
    }

    public String getStationName() {
        return this.station.getName();
    }

    public Station getNextStation() {
        return this.nextStation;
    }

    public int getDistance() {
        return distance;
    }

    public boolean isEnd() {
        return this.nextStation == null;
    }

    public int getTime() {
        return time;
    }
}
