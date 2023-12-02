package subway.repository;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.ConnectStationNode;
import subway.domain.Graph;
import subway.domain.Station;
import subway.util.constants.StationName;

import java.util.List;

import static subway.repository.StationRepository.stations;

public class GraphRepository {

    private static final GraphRepository graphRepository = new GraphRepository();
    private static final StationRepository stationRepository = StationRepository.getInstance();

    private static final WeightedMultigraph<String, DefaultWeightedEdge> GRAPH_DISTANCE = new WeightedMultigraph(
            DefaultWeightedEdge.class);
    private static final WeightedMultigraph<String, DefaultWeightedEdge> GRAPH_TIME = new WeightedMultigraph(
            DefaultWeightedEdge.class);
    private GraphRepository(){

    }

    public static GraphRepository getInstance(){
        return graphRepository;
    }

    public void initGraph(){
        addVertexs();
        setWeight();
    }

    private void addVertexs(){
        for (StationName stationName : StationName.values()) {
            GRAPH_DISTANCE.addVertex(stationName.getValue());
            GRAPH_TIME.addVertex(stationName.getValue());
        }
    }

    private void setWeight(){
        for (Station station : stations()){
            for (ConnectStationNode connectData : station.getConnectStationNodes()) {
                GRAPH_DISTANCE.setEdgeWeight(GRAPH_DISTANCE.addEdge(station.getName(), connectData.getStation().getName()), connectData.getDistance());
                GRAPH_DISTANCE.setEdgeWeight(GRAPH_TIME.addEdge(station.getName(), connectData.getStation().getName()), connectData.getTime());
            }
        }
    }

    public List<String> getShortestDistance(final Station startStation, final Station endStation){
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(GRAPH_DISTANCE);
        List<String> shortestPath = dijkstraShortestPath.getPath(startStation.getName(), endStation.getName()).getVertexList();
        return shortestPath;
    }

    public List<String> getShortestTime(final Station startStation, final Station endStation){
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(GRAPH_TIME);
        List<String> shortestPath = dijkstraShortestPath.getPath(startStation.getName(), endStation.getName()).getVertexList();
        return shortestPath;
    }
}
