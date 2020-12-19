package subway.controller;

import subway.domain.Edge;
import subway.domain.EdgeRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.Arrays;

public class SubwayController {
    public void initPrimary() {
        Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역")
                .forEach(name -> StationRepository.addStation(new Station(name)));
        EdgeRepository.addEdge(new Edge("교대역", "강남역", 2, 3));
        EdgeRepository.addEdge(new Edge("강남역", "역삼역", 2, 3));
        EdgeRepository.addEdge(new Edge("교대역", "남부터미널역", 3, 2));
        EdgeRepository.addEdge(new Edge("남부터미널역", "양재역", 6, 5));
        EdgeRepository.addEdge(new Edge("양재역", "매봉역", 1, 1));
        EdgeRepository.addEdge(new Edge("강남역", "양재역", 2, 8));
        EdgeRepository.addEdge(new Edge("양재역", "양재시민의숲역", 10, 3));
    }
}
