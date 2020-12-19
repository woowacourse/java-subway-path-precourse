package subway.controller;

import java.util.List;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.view.OutputView;

public class RouteCalculator {

    Station stationDeparture;
    Station stationArrival;
    String option;
    int totalTime = 0;
    int totalDistance = 0;


    public RouteCalculator(Station stationDeparture, Station stationArrival, String option) {
        this.stationDeparture = stationDeparture;
        this.stationArrival = stationArrival;
        this.option = option;
        try {
            if (option.equals("1")) {
                getDijkstraShortestPathByDistance();
                return;
            }

            if (option.equals("2")) {
                getDijkstraShortestPathByTime();
                return;
            }

        } catch (NullPointerException e) {
            OutputView.showErrorStationUnreachable();
        }
    }

    public void getDijkstraShortestPathByDistance() {
        WeightedMultigraph<Station, DefaultWeightedEdge> graph = new WeightedMultigraph(
            DefaultWeightedEdge.class);
        for (Line line : LineRepository.lines()) {
            graph.addVertex(line.getStations().get(0));
            for (int i = 1; i < line.getStations().size(); i++) {
                graph.addVertex(line.getStations().get(i));
                graph.setEdgeWeight(
                    graph.addEdge(line.getStations().get(i - 1), line.getStations().get(i)),
                    line.getDistances().get(i - 1));
            }
        }
        calculateShortestPath(graph);
    }

    public void getDijkstraShortestPathByTime() {
        WeightedMultigraph<Station, DefaultWeightedEdge> graph = new WeightedMultigraph(
            DefaultWeightedEdge.class);
        for (Line line : LineRepository.lines()) {
            graph.addVertex(line.getStations().get(0));
            for (int i = 1; i < line.getStations().size(); i++) {
                graph.addVertex(line.getStations().get(i));
                graph.setEdgeWeight(
                    graph.addEdge(line.getStations().get(i - 1), line.getStations().get(i)),
                    line.getTimes().get(i - 1));
            }
        }
        calculateShortestPath(graph);
    }


    public void calculateShortestPath(WeightedMultigraph graph) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        List<Station> shortestPath = dijkstraShortestPath.getPath(stationDeparture, stationArrival)
            .getVertexList();

        totalTime = (int) dijkstraShortestPath.getPathWeight(stationDeparture, stationArrival);
        OutputView.showResult(shortestPath, totalDistance, totalTime);

    }
    


}
