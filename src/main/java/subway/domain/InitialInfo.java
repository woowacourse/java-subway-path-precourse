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

    private void setShortestPath() {
        PathRepository.setGraphEdgeWeight("교대역", "강남역", 2,3);
        PathRepository.setGraphEdgeWeight("강남역", "역삼역", 2,3);
        PathRepository.setGraphEdgeWeight("교대역", "남부터미널역", 3,2);
        PathRepository.setGraphEdgeWeight("남부터미널역", "양재역", 6,5);
        PathRepository.setGraphEdgeWeight("양재역", "매봉역", 1,1);
        PathRepository.setGraphEdgeWeight("강남역", "양재역", 2,8);
        PathRepository.setGraphEdgeWeight("양재역", "양재시민의숲역", 10,3);
    }

    private void setStations() {
        for (String station : initialStations) {
            StationRepository.addStation(new Station(station));
            PathRepository.addGraphVertex(station);
        }
    }

    private void setLines() {
        for (String line : initialLines) {
            LineRepository.addLine(new Line(line));
        }
    }

}
