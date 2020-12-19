package subway.domain;

public class ConnectedStations {
    private final Station firstStation;
    private final Station secondStation;

    public ConnectedStations(Station firstStation, Station secondStation) {
        this.firstStation = firstStation;
        this.secondStation = secondStation;
    }

    public Station getFirstStation() {
        return firstStation;
    }

    public Station getSecondStation() {
        return secondStation;
    }
}
