package subway.domain;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;


public class Init {
    public static DijkstraShortestPath dijkstraDistance;
    public static DijkstraShortestPath dijkstraTime;

    public static void initialize() {
        initializeStation();
        initializeLine();
        initializeTimeGraph();
        dijkstraDistance = initializeDistanceGraph();
        dijkstraTime = initializeTimeGraph();
    }

    public static void initializeStation() {
        for (String name : Constants.STATIONS)
            StationRepository.addStation(new Station(name));
    }

    public static void initializeLine() {
        Line line2 = new Line(Constants.LINE_2);
        LineRepository.addLine(line2, Constants.LINE_2_STATIONS);
        Line line3 = new Line(Constants.LINE_3);
        LineRepository.addLine(line3, Constants.LINE_3_STATIONS);
        Line lineSinbundang = new Line(Constants.LINE_SINBUNDANG);
        LineRepository.addLine(lineSinbundang, Constants.LINE_SINBUNDANG_STATIONS);
    }

    public static DijkstraShortestPath initializeDistanceGraph() {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = initializeGraph();
        int edges = 0;
        for (Line line : LineRepository.lines())
            edges += line.getSize() - 1;
        for (int i = 0; i < edges; i++) {
            graph.setEdgeWeight(graph.addEdge("교대역", "강남역"), 2);
            graph.setEdgeWeight(graph.addEdge("강남역", "역삼역"), 2);
            graph.setEdgeWeight(graph.addEdge("교대역", "남부터미널역"), 3);
            graph.setEdgeWeight(graph.addEdge("남부터미널역", "양재역"), 6);
            graph.setEdgeWeight(graph.addEdge("양재역", "매봉역"), 1);
            graph.setEdgeWeight(graph.addEdge("강남역", "양재역"), 2);
            graph.setEdgeWeight(graph.addEdge("양재역", "양재시민의숲역"), 8);
        }
        DijkstraShortestPath dijkstraDistance = new DijkstraShortestPath(graph);
        return dijkstraDistance;
    }

    public static DijkstraShortestPath initializeTimeGraph() {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = initializeGraph();
        int edges = 0;
        for (Line line : LineRepository.lines())
            edges += line.getSize() - 1;
        for (int i = 0; i < edges; i++) {
            graph.setEdgeWeight(graph.addEdge("교대역", "강남역"), 3);
            graph.setEdgeWeight(graph.addEdge("강남역", "역삼역"), 3);
            graph.setEdgeWeight(graph.addEdge("교대역", "남부터미널역"), 2);
            graph.setEdgeWeight(graph.addEdge("남부터미널역", "양재역"), 5);
            graph.setEdgeWeight(graph.addEdge("양재역", "매봉역"), 1);
            graph.setEdgeWeight(graph.addEdge("강남역", "양재역"), 10);
            graph.setEdgeWeight(graph.addEdge("양재역", "양재시민의숲역"), 3);
        }
        DijkstraShortestPath dijkstraTime = new DijkstraShortestPath(graph);
        return dijkstraTime;
    }

    public static WeightedMultigraph<String, DefaultWeightedEdge> initializeGraph() {
        WeightedMultigraph<String, DefaultWeightedEdge> graph
                = new WeightedMultigraph(DefaultWeightedEdge.class);
        for (String name : Constants.STATIONS)
            graph.addVertex(name);
        return graph;
    }
}
