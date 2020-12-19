package subway.domain.line;

import subway.domain.station.Station;

public class LineStation {

    private Station station;
    private String routeInfo;

    public LineStation(Station station, String routeInfo) {
        this.station = station;
        this.routeInfo = routeInfo;
    }

    public LineStation(Station station) {
        this.station = station;
    }

    public LineStation(String routeInfo) {
        this.routeInfo = routeInfo;
    }

    public String getStationName() {
        return station.getName();
    }

    public Station getStation() {
        return station;
    }

    public String getRouteInfo() {
        return routeInfo;
    }

    public static LineStation of(Station station) {
        return new LineStation(station);
    }

    public static LineStation ofRouteInfo(String routeInfo) {
        return new LineStation(routeInfo);
    }
}
