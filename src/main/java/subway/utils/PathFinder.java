package subway.utils;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.data.Line;
import subway.domain.data.LineRepository;
import subway.domain.data.Station;
import subway.domain.data.StationRepository;

import java.util.List;

public class PathFinder {

    private WeightedMultigraph<String, DefaultWeightedEdge> timeGraph;
    private WeightedMultigraph<String, DefaultWeightedEdge> distanceGraph;
    private DijkstraShortestPath timeShortestPath;
    private DijkstraShortestPath distanceShortestPath;

    public PathFinder() {
        timeGraph = new WeightedMultigraph(DefaultWeightedEdge.class);
        distanceGraph = new WeightedMultigraph(DefaultWeightedEdge.class);

        initTimeData();
        initDistanceData();
        timeShortestPath = new DijkstraShortestPath(timeGraph);
        distanceShortestPath = new DijkstraShortestPath(distanceGraph);
    }

    public List<String> getShortestTimeList(String startingStation, String endingStation){
        return timeShortestPath.getPath(startingStation, endingStation).getVertexList();
    }

    public double getShortestTimeWeight(String startingStation, String endingStation){
        return timeShortestPath.getPathWeight(startingStation, endingStation);
    }

    public List<String> getShortestDistanceList(String startingStation, String endingStation){
        return distanceShortestPath.getPath(startingStation, endingStation).getVertexList();
    }

    public double getShortestDistanceWeight(String startingStation, String endingStation){
        return distanceShortestPath.getPathWeight(startingStation, endingStation);
    }


    private void initTimeData() {
        for (Station station : StationRepository.stations()) {
            timeGraph.addVertex(station.getName());
        }

        for (Line line : LineRepository.lines()) {
            List<Station> stationList = line.getStationList();
            List<Integer> stationPathTime = line.getStationPathTime();

            for (int i = 0; i < stationList.size() - 1; i++) {
                timeGraph.setEdgeWeight(timeGraph.addEdge(stationList.get(i).getName(), stationList.get(i + 1).getName())
                        , stationPathTime.get(i));
            }
        }
    }

    private void initDistanceData() {
        for (Station station : StationRepository.stations()) {
            distanceGraph.addVertex(station.getName());
        }

        for (Line line : LineRepository.lines()) {
            List<Station> stationList = line.getStationList();
            List<Integer> stationPathDistance = line.getStationPathDistance();

            for (int i = 0; i < stationList.size() - 1; i++) {
                distanceGraph.setEdgeWeight(distanceGraph.addEdge(stationList.get(i).getName()
                        , stationList.get(i + 1).getName()), stationPathDistance.get(i));
            }
        }
    }
}
