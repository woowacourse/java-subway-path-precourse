package subway.domain;

public class NearbyStation {
    private final Station station;
    private final int distance;
    private final int time;

    public NearbyStation(Station station, int distance, int time) {
        this.station = station;
        this.distance = distance;
        this.time = time;
    }

    public Station getStation() {
        return station;
    }

    public int getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }
}
