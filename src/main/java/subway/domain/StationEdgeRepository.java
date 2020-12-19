package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StationEdgeRepository {
    private static final List<StationEdge> stationEdges = new ArrayList<>();

    public static List<StationEdge> stations() {
        return Collections.unmodifiableList(stationEdges);
    }

    public static void addStation(StationEdge station) {
        stationEdges.add(station);
    }

    public static int getDistanceInterval(String from,String to){
        return stationEdges.stream().filter(stationEdge -> {
            return stationEdge.getFrom().equals(from)&&stationEdge.getTo().equals(to);
        }).findAny().get().getDistance();
    }

    public static int getTimeInterval(String from,String to){
        return stationEdges.stream().filter(stationEdge -> {
            return stationEdge.getFrom().equals(from)&&stationEdge.getTo().equals(to);
        }).findFirst().get().getTime();
    }
}
