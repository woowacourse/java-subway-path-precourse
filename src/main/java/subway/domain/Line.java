package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private static final int ORDER_CONSTANT = 1;

    private String name;
    private List<Station> stations = new ArrayList<>();
    private List<Edge> edges = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void addStation(Station station, int order) {
        int indexOrder = order - ORDER_CONSTANT;
        stations.add(indexOrder,station);
    }

    public void addEdge(Edge edge, int order) {
        edges.add(order,edge);
    }

    public void addStationByName(String stationName, int order) {
        for (int i = 0; i < StationRepository.stations().size(); i++) {
            Station station = StationRepository.stations().get(i);
            if (station.getName().equals(stationName)) {
                addStation(station, order);
            }
        }
    }

    public List<String> getStationNameList() {
        List<String> stationList = new ArrayList<String>();
        for (int i = 0; i < stations.size(); i++) {
            stationList.add(stations.get(i).getName());
        }
        return stationList;
    }
}
