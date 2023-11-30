package subway.domain;

public class ConnectStationNode {
    private Station station;
    private int distance;
    private int time;

    private ConnectStationNode(Station station, int distance, int time){
        this.station = station;
        this.distance = distance;
        this.time = time;
    }

    public static ConnectStationNode create(Station station, int distance, int time){
        return new ConnectStationNode(station, distance, time);
    }
}
