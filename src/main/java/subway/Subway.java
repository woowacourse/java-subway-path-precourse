package subway;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import subway.domain.DistancePathRepository;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.SectionRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.domain.TimePathRepository;
import subway.util.InitConstants;
import subway.view.MainView;

public class Subway {

    private final StationRepository stationRepository = new StationRepository();
    private final LineRepository lineRepository = new LineRepository();
    private final SectionRepository sectionRepository = new SectionRepository();
    private final TimePathRepository timePathRepository = new TimePathRepository();
    private final DistancePathRepository distancePathRepository = new DistancePathRepository();

    public Subway() {
        loadInitData();
    }

    private void loadInitData() {
        loadInitStationData();
        loadInitLineData();
        loadInitSectionData();
        loadInitDistanceData();
        loadInitTimeData();
    }

    public void launch(Scanner scanner) {
        MainView mainView = new MainView(this, scanner);
        mainView.start();
    }

    private void loadInitDistanceData() {
        InitConstants.LINE_LIST.forEach(line -> distancePathRepository
            .addNewLine(lineRepository.findByName(line), InitConstants.SECTION_LIST.get(line)));
        for (List<String> element : InitConstants.DISTANCE_PATH_LIST) {
            distancePathRepository.addEdgeWeight(
                lineRepository.findByName(element.get(0)),
                stationRepository.findByName(element.get(1)),
                stationRepository.findByName(element.get(2)),
                Integer.parseInt(element.get(3)));
        }
    }

    private void loadInitTimeData() {
        InitConstants.LINE_LIST.forEach(line -> timePathRepository
            .addNewLine(lineRepository.findByName(line), InitConstants.SECTION_LIST.get(line)));
        for (List<String> element : InitConstants.TIME_PATH_LIST) {
            timePathRepository.addEdgeWeight(
                lineRepository.findByName(element.get(0)),
                stationRepository.findByName(element.get(1)),
                stationRepository.findByName(element.get(2)),
                Integer.parseInt(element.get(3)));
        }
    }

    private void loadInitStationData() {
        InitConstants.STATION_LIST.forEach(name -> stationRepository.addStation(new Station(name)));
    }

    private void loadInitLineData() {
        InitConstants.LINE_LIST.forEach(name -> lineRepository.addLine(new Line(name)));
    }

    private void loadInitSectionData() {
        InitConstants.SECTION_LIST.forEach((key, value) -> { // {lineName, List<stationName>}
            List<Station> stations = value.stream() // stationName
                .map(stationRepository::findByName) // Station
                .collect(Collectors.toList()); // List<Station>
            Line line = lineRepository.findByName(key); // Line
            sectionRepository.addStationList(line, stations); // Map.put(Line,List<Station>)
        });
    }

    public StationRepository getStationRepository() {
        return stationRepository;
    }

    public LineRepository getLineRepository() {
        return lineRepository;
    }


    public TimePathRepository getTimePathRepository() {
        return timePathRepository;
    }

    public DistancePathRepository getDistancePathRepository() {
        return distancePathRepository;
    }

    public SectionRepository getSectionRepository() {
        return sectionRepository;
    }


}
