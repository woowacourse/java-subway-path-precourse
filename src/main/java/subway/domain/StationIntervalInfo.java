package subway.domain;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.List;

public class StationIntervalInfo {
    private WeightedMultigraph<Station, DefaultWeightedEdge> distanceGraph = new WeightedMultigraph<>(DefaultWeightedEdge.class);
    private WeightedMultigraph<Station, DefaultWeightedEdge> timeGraph = new WeightedMultigraph<>(DefaultWeightedEdge.class);

    public StationIntervalInfo() {
        setDistanceGraph();
        setTimeGraph();
    }

    public  void setDistanceGraph() {
        Station gyodae = StationRepository.findByName("교대역");
        Station gangnam = StationRepository.findByName("강남역");
        Station yeoksam = StationRepository.findByName("역삼역");
        Station nambuTerminal = StationRepository.findByName("남부터미널역");
        Station yangjae = StationRepository.findByName("양재역");
        Station yangjaeCitizenForest = StationRepository.findByName("양재시민의숲역");
        Station maebong = StationRepository.findByName("매봉역");

        List<Station> stations = List.of(gyodae, gangnam, yeoksam, nambuTerminal, yangjae, yangjaeCitizenForest, maebong);

        stations.stream().forEach(station -> StationRepository.addStation(station));
        stations.stream().forEach(station -> distanceGraph.addVertex(station));

        //2호선 구간 정보
        distanceGraph.setEdgeWeight(distanceGraph.addEdge(gyodae, gangnam), 2);
        distanceGraph.setEdgeWeight(distanceGraph.addEdge(gangnam, yeoksam), 2);

        //3호선 구간 정보
        distanceGraph.setEdgeWeight(distanceGraph.addEdge(gyodae, nambuTerminal), 3);
        distanceGraph.setEdgeWeight(distanceGraph.addEdge(nambuTerminal, yangjae), 6);
        distanceGraph.setEdgeWeight(distanceGraph.addEdge(yangjae, maebong), 1);

        //신분당선 구간 정보
        distanceGraph.setEdgeWeight(distanceGraph.addEdge(gangnam, yangjae), 2);
        distanceGraph.setEdgeWeight(distanceGraph.addEdge(yangjae, yangjaeCitizenForest), 10);
    }

    public  void setTimeGraph() {
        Station gyodae = StationRepository.findByName("교대역");
        Station gangnam = StationRepository.findByName("강남역");
        Station yeoksam = StationRepository.findByName("역삼역");
        Station nambuTerminal = StationRepository.findByName("남부터미널역");
        Station yangjae = StationRepository.findByName("양재역");
        Station yangjaeCitizenForest = StationRepository.findByName("양재시민의숲역");
        Station maebong = StationRepository.findByName("매봉역");

        List<Station> stations = List.of(gyodae, gangnam, yeoksam, nambuTerminal, yangjae, yangjaeCitizenForest, maebong);

        stations.stream().forEach(station -> StationRepository.addStation(station));
        stations.stream().forEach(station -> distanceGraph.addVertex(station));

        //2호선 구간 정보
        distanceGraph.setEdgeWeight(distanceGraph.addEdge(gyodae, gangnam), 3);
        distanceGraph.setEdgeWeight(distanceGraph.addEdge(gangnam, yeoksam), 3);

        //3호선 구간 정보
        distanceGraph.setEdgeWeight(distanceGraph.addEdge(gyodae, nambuTerminal), 2);
        distanceGraph.setEdgeWeight(distanceGraph.addEdge(nambuTerminal, yangjae), 5);
        distanceGraph.setEdgeWeight(distanceGraph.addEdge(yangjae, maebong), 1);

        //신분당선 구간 정보
        distanceGraph.setEdgeWeight(distanceGraph.addEdge(gangnam, yangjae), 8);
        distanceGraph.setEdgeWeight(distanceGraph.addEdge(yangjae, yangjaeCitizenForest), 3);
    }

    public SubwayPathRecommendationResult getShortestPath(Station start, Station end) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(distanceGraph);
        double totalDistance = dijkstraShortestPath.getPath(start, end).getWeight();
        List<Station> vertexList = dijkstraShortestPath.getPath(start, end).getVertexList();

        return new SubwayPathRecommendationResult((int) totalDistance, 0, vertexList);
    }

    public void setLine() {
        Line two = new Line("2호선");
        Line three = new Line("3호선");
        Line sinbundang = new Line("신분당선");

        List<Line> lines = List.of(two, three, sinbundang);

        lines.stream().forEach(line -> LineRepository.addLine(line));
    }
}
