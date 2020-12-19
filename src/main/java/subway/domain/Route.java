package subway.domain;

import subway.enums.initializer.*;

import java.util.List;

public class Route {
    private InitialLines line;
    private List<InitialStations> stations;
    private TimeToStation timeToNextStation;
    private DistanceToStation distanceToNextStation;

    public Route(InitialRoutes initialRoutes) {
        this.line = initialRoutes.getLine();
        this.stations = initialRoutes.getStations();
        this.timeToNextStation = initialRoutes.getTimeToNextStation();
        this.distanceToNextStation = initialRoutes.getDistanceToNextStation();
    }

    public InitialLines getLine() {
        return line;
    }

    public List<InitialStations> getStations() {
        return stations;
    }

    public TimeToStation getTimeToNextStation() {
        return timeToNextStation;
    }

    public DistanceToStation getDistanceToNextStation() {
        return distanceToNextStation;
    }
}
