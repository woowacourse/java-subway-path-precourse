package subway.domain;

public class SubwayInitializer {
    public static void initialize() {
        initializeStations();
        initializeEdges();
    }
    
    private static void initializeStations() {
        StationRepository.addStation(new Station("교대역"));
        StationRepository.addStation(new Station("강남역"));
        StationRepository.addStation(new Station("역삼역"));
        StationRepository.addStation(new Station("남부터미널역"));
        StationRepository.addStation(new Station("양재역"));
        StationRepository.addStation(new Station("매봉역"));
        StationRepository.addStation(new Station("양재시민의숲역"));
    }
    
    private static void initializeEdges() {
        EdgeRepository.addEdgeByNamesAndNumbers("교대역", "강남역", 2, 3);
        EdgeRepository.addEdgeByNamesAndNumbers("강남역", "역삼역", 2, 3);
        EdgeRepository.addEdgeByNamesAndNumbers("교대역", "남부터미널역", 3, 2);
        EdgeRepository.addEdgeByNamesAndNumbers("남부터미널역", "양재역", 6, 5);
        EdgeRepository.addEdgeByNamesAndNumbers("양재역", "매봉역", 1, 1);
        EdgeRepository.addEdgeByNamesAndNumbers("강남역", "양재역", 2, 8);
        EdgeRepository.addEdgeByNamesAndNumbers("양재역", "양재시민의숲역", 10, 3);
    }
}
