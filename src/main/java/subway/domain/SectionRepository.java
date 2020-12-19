package subway.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.util.Constants;

public class SectionRepository {

    private final Map<Line, List<Station>> sections = new HashMap<>();
    WeightedMultigraph<String, DefaultWeightedEdge> timeBetweenStation = new WeightedMultigraph(
        DefaultWeightedEdge.class);
    WeightedMultigraph<String, DefaultWeightedEdge> distanceBetweenStation = new WeightedMultigraph(
        DefaultWeightedEdge.class);


    public SectionRepository() {
    }

    public void addStationList(Line line, List<Station> stations) {
        sections.put(line, new LinkedList<>(stations)); // mutable
    }

    public void addWeightedMultigraph(Line line, Station startStation, Station endStation,
        int distance, int time) {
        distanceBetweenStation.setEdgeWeight(
            distanceBetweenStation.addEdge(startStation.getName(), endStation.getName()), distance);
        timeBetweenStation
            .setEdgeWeight(timeBetweenStation.addEdge(startStation.getName(), endStation.getName()),
                time);
    }


    public void addNewLineN(Line line, List<Station> stations, int distance, int time) {
        ListIterator<Station> stationsIter = stations.listIterator();
        while (stationsIter.hasNext()) {
            System.out.println(stationsIter.next().getName());
            System.out.println(stationsIter.next().getName());

//            timeBetweenStation
//                .setEdgeWeight(timeBetweenStation.addEdge(stationsIter, stationsIter.next()), time),
//                2);
//            distanceBetweenStation.setEdgeWeight(distanceBetweenStation.addEdge("v1", "v2"), 2);
        }
    }

    public void addNewLine(Line line, Station startStation, Station endStation) {
        addStationList(line, List.of(startStation, endStation)); // immutable
    }

    public void addSection(Line line, Station station, int index) {
        List<Station> stations = sections.get(line);
        stations.add(index - Constants.INDEX_ARRANGE_INT, station);
    }

    public int getSize(Line line) {
        return sections.get(line).size();
    }

    public boolean isExistStationInLine(Line line, Station station) {
        return sections.getOrDefault(line, List.of()).contains(station);
    }

    public void deleteLine(Line line) {
        sections.remove(line);
    }

    public void deleteSection(Line line, Station station) {
        sections.get(line).remove(station);
    }

    public Set<Station> findAllStations() {
        return sections.values().stream() // List<Station>
            .flatMap(Collection::stream) // Station
            .collect(Collectors.toSet()); // Set.add(Station)
    }

    public Map<Line, List<Station>> findAll() {
        Map<Line, List<Station>> copiedMap = new HashMap<>();
        sections.forEach((line, stations) -> //Line, List<Station>
            copiedMap.put(line, new ArrayList<>(stations))); // Map.put(Line, List<Station>)
        return copiedMap; // Copy to protect instance data (but, return data is mutable)
    }
}
