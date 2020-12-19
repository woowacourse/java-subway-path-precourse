package subway.util;

import java.util.HashMap;
import java.util.Map;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.Station.Station;
import subway.domain.Station.StationRepository;
import subway.domain.subwaymap.SubwayMap;
import subway.domain.subwaymap.SubwayMapRepository;

public class SubwayDataFactory {

    public void makeSubwayData() {
        Map<String, Station> stations = new HashMap<>();

        stations.put("교대역", new Station("교대역"));
        stations.put("강남역", new Station("강남역"));
        stations.put("역삼역", new Station("역삼역"));
        stations.put("남부터미널역", new Station("남부터미널역"));
        stations.put("양재역", new Station("양재역"));
        stations.put("양재시민의숲역", new Station("양재시민의숲역"));
        stations.put("매봉역", new Station("매봉역"));

        for (String key : stations.keySet()) {
            StationRepository.addStation(stations.get(key));
        }

        SubwayMapRepository.addSubwayMaps("테스트용 지하철 노선도", new SubwayMap("테스트용 지하철 노선도",
            makeDistanceBasedSubwayMap(stations),
            makeTimeBasedSubwayMap(stations)));
    }

    private WeightedMultigraph<Station, DefaultWeightedEdge> makeDistanceBasedSubwayMap(
        Map<String, Station> stations) {
        WeightedMultigraph<Station, DefaultWeightedEdge> distanceBasedSubwayMap
            = new WeightedMultigraph(DefaultWeightedEdge.class);

        for (String key : stations.keySet()) {
            distanceBasedSubwayMap.addVertex(stations.get(key));
        }
        distanceBasedSubwayMap
            .setEdgeWeight(distanceBasedSubwayMap.addEdge(stations.get("교대역"), stations.get("강남역")),
                2);
        distanceBasedSubwayMap
            .setEdgeWeight(distanceBasedSubwayMap.addEdge(stations.get("강남역"), stations.get("역삼역")),
                2);

        distanceBasedSubwayMap
            .setEdgeWeight(
                distanceBasedSubwayMap.addEdge(stations.get("교대역"), stations.get("남부터미널역")), 3);
        distanceBasedSubwayMap
            .setEdgeWeight(
                distanceBasedSubwayMap.addEdge(stations.get("남부터미널역"), stations.get("양재역")), 6);
        distanceBasedSubwayMap
            .setEdgeWeight(distanceBasedSubwayMap.addEdge(stations.get("양재역"), stations.get("매봉역")),
                1);

        distanceBasedSubwayMap
            .setEdgeWeight(distanceBasedSubwayMap.addEdge(stations.get("강남역"), stations.get("양재역")),
                2);
        distanceBasedSubwayMap
            .setEdgeWeight(
                distanceBasedSubwayMap.addEdge(stations.get("양재역"), stations.get("양재시민의숲역")), 10);

        return distanceBasedSubwayMap;
    }

    private WeightedMultigraph<Station, DefaultWeightedEdge> makeTimeBasedSubwayMap(
        Map<String, Station> stations) {

        WeightedMultigraph<Station, DefaultWeightedEdge> timeBasedSubwayMap
            = new WeightedMultigraph(DefaultWeightedEdge.class);

        for (String key : stations.keySet()) {
            timeBasedSubwayMap.addVertex(stations.get(key));
        }
        timeBasedSubwayMap
            .setEdgeWeight(timeBasedSubwayMap.addEdge(stations.get("교대역"), stations.get("강남역")), 3);
        timeBasedSubwayMap
            .setEdgeWeight(timeBasedSubwayMap.addEdge(stations.get("강남역"), stations.get("역삼역")), 3);

        timeBasedSubwayMap
            .setEdgeWeight(timeBasedSubwayMap.addEdge(stations.get("교대역"), stations.get("남부터미널역")),
                2);
        timeBasedSubwayMap
            .setEdgeWeight(timeBasedSubwayMap.addEdge(stations.get("남부터미널역"), stations.get("양재역")),
                5);
        timeBasedSubwayMap
            .setEdgeWeight(timeBasedSubwayMap.addEdge(stations.get("양재역"), stations.get("매봉역")), 1);

        timeBasedSubwayMap
            .setEdgeWeight(timeBasedSubwayMap.addEdge(stations.get("강남역"), stations.get("양재역")), 8);
        timeBasedSubwayMap
            .setEdgeWeight(timeBasedSubwayMap.addEdge(stations.get("양재역"), stations.get("양재시민의숲역")),
                3);

        return timeBasedSubwayMap;

    }

}
