package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class ConnectedStationsRepository {
    private static final List<ConnectedStations> connectedStations = new ArrayList<>();

    public static void addConnectedStations(ConnectedStations connectedStationsToAdd) {
        connectedStations.add(connectedStationsToAdd);
    }
}
