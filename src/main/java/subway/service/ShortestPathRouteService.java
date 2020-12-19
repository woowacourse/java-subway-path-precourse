package subway.service;

import java.util.List;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.Route;
import subway.domain.RouteRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class ShortestPathRouteService {
    private WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);

    public void getDijkstraShortestPath(String startStation, String endStation) {
        addVertex();
        setEdgeWeight();
    }

    public void addVertex(){
        List<Station> stations = StationRepository.stations();
        for(Station station : stations){
            graph.addVertex(station.getName());
        }
    }

    public void setEdgeWeight(){
        List<Route> routes = RouteRepository.routes();
        for(Route route: routes){
            String currentStationName = route.getStation().getName();
            String nextStationName = route.getNext().getName();
            graph.setEdgeWeight(graph.addEdge(currentStationName,nextStationName),route.getDistance());
        }
    }
}
