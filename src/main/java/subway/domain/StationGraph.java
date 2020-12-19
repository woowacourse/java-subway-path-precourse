package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class StationGraph {
    private List<List<Section>> stationDistanceGraph;
    public StationGraph() {
        stationDistanceGraph = new ArrayList<>();
    }

    public List<List<Section>> getStationDistanceGraph() {
        return stationDistanceGraph;
    }
}
