package subway;

import subway.domain.Section;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.exception.SameStationsException;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;
import java.util.Objects;

public class SectionService {
    private static final String INPUT_STATION_FROM = "출발역을 입력하세요.";
    private static final String INPUT_STATION_TO = "도착역을 입력하세요.";
    private static final String CUT_LINE = "---";
    private static final String TOTAL_DISTANCE = "총 거리:";
    private static final String TOTAL_TIME = "총 소요 시간:";

    private List<Section> sections;
    private String stationFromName;
    private String stationToName;



    public void findPath(String command, InputView inputView) {
        if(command == WeightType.DISTANCE.getCommand()) {
            //거리 순
            findPathByDistance(inputView);
        }
        if(command == WeightType.TIME.getCommand()) {
            // 시간 순
            findPathByTime(inputView);
        }
    }

    private void findPathByDistance(InputView inputView) {
        setStationFromTo(inputView);
//        WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph<>(DefaultWeightedEdge.class);
//        graph.addVertex("stationFrom");
//        graph.addVertex("StationTo");
//        graph.setEdgeWeight(graph.addEdge());
//        showResult();

    }

    private void findPathByTime(InputView inputView) {
        setStationFromTo(inputView);
//        showResult();
    }

    private void setStationFromTo(InputView inputView) {
        OutputView.printlnGuide(INPUT_STATION_FROM);
        this.stationFromName = inputView.scanStationName();
        OutputView.printlnGuide(INPUT_STATION_TO);
        this.stationToName = inputView.scanStationName();
        if(Objects.equals(stationFromName,stationToName)) {
            throw new SameStationsException(stationFromName);
        }
    }

    private void showResult(int totalDistance, int totalTime, List<Station> stationList) {
        String totalDistanceStr = String.valueOf(totalDistance);
        String totalTimeStr = String.valueOf(totalTime);

        OutputView.printlnResult(CUT_LINE);
        OutputView.printlnResult(TOTAL_DISTANCE, totalDistanceStr);
        OutputView.printlnResult(TOTAL_TIME, totalTimeStr);
        OutputView.printlnResult(CUT_LINE);
        stationList.stream().forEach(station -> OutputView.printlnResult(station.getName()));
    }
}
