package subway;

import subway.domain.Edge;
import subway.domain.Station;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MinimumTime {

    private ArrayList<Edge>[] subwayNetwork;
    private Map<Station, Integer> stationMapper = new HashMap<>();

    public MinimumTime(Map<Station, Integer> stationMapper,
                            ArrayList<Edge>[] subwayNetwork) {
        this.subwayNetwork = subwayNetwork;
        this.stationMapper = stationMapper;
    }
}
