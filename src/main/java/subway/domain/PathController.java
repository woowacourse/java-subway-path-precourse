package subway.domain;

import org.jgrapht.Graph;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;

import java.util.ArrayList;
import java.util.List;

public class PathController {

    public Station findStation(String stationName) {
        Station searchedStation = StationRepository.stations()
                .stream().parallel()
                .filter(station -> station.getName().equals(stationName))
                .findAny().orElseThrow(IllegalArgumentException::new);
        return searchedStation;
    }

    public List<Line> findLine(Station station) {
        List<Line> lineList = new ArrayList<>();
        for (Line line : LineRepository.lines()) {
            if (line.getStation().contains(station)) {
                lineList.add(line);
            }
        }
        return lineList;
    }

    public boolean isExistCrossLine(Station startStation, Station endStation) {
        List<Line> startLine = findLine(startStation);
        List<Line> endLine = findLine(endStation);
        for (Line line : startLine) {
            if (endLine.contains(line)) {
                return true;
            }
        }
        return false;
    }

    public Line findCrossLine(Station startStation, Station endStation) {
        List<Line> startLine = findLine(startStation);
        List<Line> endLine = findLine(endStation);
        for (Line line : startLine) {
            if (endLine.contains(line)) {
                return line;
            }
        }
        throw new IllegalArgumentException();
    }


    public List<Station> findPath(Station startStation, Station endStation) {
        List<Station> path = new ArrayList<>();
        if (isExistCrossLine(startStation, endStation)) {
            Line crossLine = findCrossLine(startStation, endStation);
            int startIndex = crossLine.getStation().indexOf(startStation);
            int endIndex = crossLine.getStation().indexOf(endStation);
            if (startIndex >= endIndex) {
                path.add(crossLine.getStation().get(startIndex));
                startIndex--;
            }
            if (endIndex >= startIndex) {
                path.add(crossLine.getStation().get(endIndex));
                endIndex--;
            }
        }
        return path;
    }

    public List getShortestDistancePath(String startStation, String endStation) {
        Graph<String, DefaultWeightedEdge> graph = StationRepository.getShortestDistancePath();
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        return dijkstraShortestPath.getPath(startStation, endStation).getVertexList();
    }

    public List getShortestTimePath(String startStation, String endStation) {
        Graph<String, DefaultWeightedEdge> graph = StationRepository.getShortestTimePath();
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        return dijkstraShortestPath.getPath(startStation, endStation).getVertexList();
    }







}
