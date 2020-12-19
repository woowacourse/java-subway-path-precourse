package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class ConnectedStationRepository {
    private static final List<ConnectedStation> connectedStations = new ArrayList<>();

    public static void addConnectedStation(ConnectedStation connectedStation) {
        connectedStations.add(connectedStation);
    }

    public static ConnectedStation getConnectedStation(Station startStation, Station endStation) {
        for (ConnectedStation connectedStation : connectedStations) {
            if (
                (connectedStation.getFirstStation().getName().equals(startStation.getName())
                    && connectedStation.getSecondStation().getName().equals(endStation.getName()))
                    || (connectedStation.getFirstStation().getName().equals(endStation.getName())
                    && connectedStation.getSecondStation().getName().equals(startStation.getName())
                )) {
                return connectedStation;
            }
        }
        return null;
    }
}
