package subway.domain;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.List;

public class StationIntervalInfo {
    private WeightedMultigraph<Station, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);

    public StationIntervalInfo(String standardCode) {
        setStationsBy(standardCode);
    }
    private void setStationsBy(String standardCode) {
        switch (standardCode) {
            case "1":
                setStationDistances();
                break;
        }
    }
    public  void setStationDistances() {
        Station gyodae = new Station("교대역");
        Station gangnam = new Station("강남역");
        Station yeoksam = new Station("역삼역");
        Station nambuTerminal = new Station("남부터미널역");
        Station yangjae = new Station("양재역");
        Station yangjaeCitizenForest = new Station("양재시민의숲역");
        Station maebong = new Station("매봉역");

        List<Station> stations = List.of(gyodae, gangnam, yeoksam, nambuTerminal, yangjae, yangjaeCitizenForest, maebong);

        stations.stream().forEach(station -> StationRepository.addStation(station));
        stations.stream().forEach(station -> graph.addVertex(station));

        //2호선 구간 정보
        graph.setEdgeWeight(graph.addEdge(gyodae, gangnam), 2);
        graph.setEdgeWeight(graph.addEdge(gangnam, yeoksam), 2);

        //3호선 구간 정보
        graph.setEdgeWeight(graph.addEdge(gyodae, nambuTerminal), 3);
        graph.setEdgeWeight(graph.addEdge(nambuTerminal, yangjae), 6);
        graph.setEdgeWeight(graph.addEdge(yangjae, maebong), 1);

        //신분당선 구간 정보
        graph.setEdgeWeight(graph.addEdge(gangnam, yangjae), 2);
        graph.setEdgeWeight(graph.addEdge(yangjae, yangjaeCitizenForest), 10);
    }

    public void setLine() {
        Line two = new Line("2호선");
        Line three = new Line("3호선");
        Line sinbundang = new Line("신분당선");

        List<Line> lines = List.of(two, three, sinbundang);

        lines.stream().forEach(line -> LineRepository.addLine(line));
    }
}
