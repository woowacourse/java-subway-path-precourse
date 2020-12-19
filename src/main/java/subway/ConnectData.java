package subway;

import subway.domain.Station;

public class ConnectData {
    private Station station;
    private int distance;
    private int time;

    public ConnectData(Station station, int distance, int time) {
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
