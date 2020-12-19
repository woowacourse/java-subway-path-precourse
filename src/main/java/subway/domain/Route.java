package subway.domain;

import subway.enums.initializer.*;

import java.util.List;

public class Route {
    private InitialLines line;
    private List<InitialStations> stations;
    private List<Integer> timeToNextStation;
    private List<Integer> distanceToNextStation;

    public Route(InitialRoutes initialRoutes) {
        this.line = initialRoutes.getLine();
        this.stations = initialRoutes.getStations();
        this.timeToNextStation = initialRoutes.getTimeToNextStation().getTimes();
        this.distanceToNextStation = initialRoutes.getDistanceToNextStation().getDistance();
    }

    public InitialLines getLine() {
        return line;
    }

    public List<InitialStations> getStations() {
        return stations;
    }

    public List<Integer> getTimeToNextStation() {
        return timeToNextStation;
    }

    public List<Integer> getDistanceToNextStation() {
        return distanceToNextStation;
    }
}
