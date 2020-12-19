package subway.domain;

public class InitialInfo {
    private final String[] initialStations = {"교대역", "강남역", "역삼역", "남부터미널역", "양재역",
        "양재시민의숲역", "매봉역"};
    private final String[] initialLines = {"2호선", "3호선", "신분당선"};

    public InitialInfo() {
        initInfo();
    }

    private void initInfo() {
        setStations();
        setLines();
        setShortestPath();
    }
    //todo: 라인에 맞게 역 설정하는 것
    private void setShortestPath() {
        ShortestPathRepository.addGraphVertex("교대역");
        ShortestPathRepository.addGraphVertex("강남역");
        ShortestPathRepository.addGraphVertex("역삼역");
        ShortestPathRepository.setGraphEdgeWeight("교대역", "강남역", 2);
        ShortestPathRepository.setGraphEdgeWeight("강남역", "역삼역", 2);
    }


    private void setStations() {
        for (String station : initialStations) {
            StationRepository.addStation(new Station(station));
        }
    }

    private void setLines() {
        for (String line : initialLines) {
            LineRepository.addLine(new Line(line));
        }
    }


}
