package subway.domain;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.*;

public class StationRepository {
    static final Station stationKyoDae = new Station("교대역");
    static final Station stationGangNam = new Station("강남역");
    static final Station stationYeokSam = new Station("역삼역");
    static final Station stationNamBu = new Station("남부터미널역");
    static final Station stationYangJae = new Station("양재역");
    static final Station stationYangJaeForest = new Station("양재시민의숲역");
    static final Station stationMaeBong = new Station("매봉역");

    private static final List<Station> stations = Arrays.asList(stationKyoDae, stationGangNam,
                                                    stationYeokSam, stationNamBu, stationYangJae,
                                                    stationYangJaeForest, stationMaeBong);
    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public void getShortestDistancePath() {
        WeightedMultigraph<String, DefaultWeightedEdge> graph
                = new WeightedMultigraph(DefaultWeightedEdge.class);
        graph.addVertex(stationKyoDae.getName());
        graph.addVertex(stationGangNam.getName());
        graph.addVertex(stationYeokSam.getName());
        graph.addVertex(stationNamBu.getName());
        graph.addVertex(stationYangJae.getName());
        graph.addVertex(stationYangJaeForest.getName());
        graph.addVertex(stationMaeBong.getName());
        graph.setEdgeWeight(graph.addEdge(stationKyoDae.getName(), stationGangNam.getName()), 2);
        graph.setEdgeWeight(graph.addEdge(stationGangNam.getName(), stationYeokSam.getName()), 2);
        graph.setEdgeWeight(graph.addEdge(stationKyoDae.getName(), stationNamBu.getName()), 3);
        graph.setEdgeWeight(graph.addEdge(stationNamBu.getName(), stationYangJae.getName()), 6);
        graph.setEdgeWeight(graph.addEdge(stationYangJae.getName(), stationMaeBong.getName()), 1);
        graph.setEdgeWeight(graph.addEdge(stationGangNam.getName(), stationYangJae.getName()), 2);
        graph.setEdgeWeight(graph.addEdge(stationYangJae.getName(), stationYangJaeForest.getName()), 10);
    }

    public void getShortestTimePath() {
        WeightedMultigraph<String, DefaultWeightedEdge> graph
                = new WeightedMultigraph(DefaultWeightedEdge.class);
        graph.addVertex(stationKyoDae.getName());
        graph.addVertex(stationGangNam.getName());
        graph.addVertex(stationYeokSam.getName());
        graph.addVertex(stationNamBu.getName());
        graph.addVertex(stationYangJae.getName());
        graph.addVertex(stationYangJaeForest.getName());
        graph.addVertex(stationMaeBong.getName());
        graph.setEdgeWeight(graph.addEdge(stationKyoDae.getName(), stationGangNam.getName()), 3);
        graph.setEdgeWeight(graph.addEdge(stationGangNam.getName(), stationYeokSam.getName()), 3);
        graph.setEdgeWeight(graph.addEdge(stationKyoDae.getName(), stationNamBu.getName()), 2);
        graph.setEdgeWeight(graph.addEdge(stationNamBu.getName(), stationYangJae.getName()), 5);
        graph.setEdgeWeight(graph.addEdge(stationYangJae.getName(), stationMaeBong.getName()), 1);
        graph.setEdgeWeight(graph.addEdge(stationGangNam.getName(), stationYangJae.getName()), 8);
        graph.setEdgeWeight(graph.addEdge(stationYangJae.getName(), stationYangJaeForest.getName()), 3);
    }


    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static void deleteAll() {
        stations.clear();
    }
}
