package subway.domain;

public class ConnectedStation {
    private final Station firstStation;
    private final Station secondStation;

    public ConnectedStation(Station firstStation, Station secondStation) {
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
