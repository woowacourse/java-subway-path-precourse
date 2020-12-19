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
        for (String line : InitConstants.LINE_LIST) {
            distancePathRepository
                .addNewLine(lineRepository.findByName(line), InitConstants.SECTION_LIST.get(line));
        }

        distancePathRepository.addEdgeWeight(
            lineRepository.findByName("2호선"),
            stationRepository.findByName("교대역"),
            stationRepository.findByName("강남역"), 2);

        distancePathRepository.addEdgeWeight(
            lineRepository.findByName("2호선"),
            stationRepository.findByName("강남역"),
            stationRepository.findByName("역삼역"), 2);

        distancePathRepository.addEdgeWeight(
            lineRepository.findByName("3호선"),
            stationRepository.findByName("교대역"),
            stationRepository.findByName("남부터미널역"), 3);

        distancePathRepository.addEdgeWeight(
            lineRepository.findByName("3호선"),
            stationRepository.findByName("남부터미널역"),
            stationRepository.findByName("양재역"), 6);

        distancePathRepository.addEdgeWeight(
            lineRepository.findByName("3호선"),
            stationRepository.findByName("양재역"),
            stationRepository.findByName("매봉역"), 1);

        distancePathRepository.addEdgeWeight(
            lineRepository.findByName("신분당선"),
            stationRepository.findByName("강남역"),
            stationRepository.findByName("양재역"), 2);

        distancePathRepository.addEdgeWeight(
            lineRepository.findByName("신분당선"),
            stationRepository.findByName("양재역"),
            stationRepository.findByName("양재시민의숲역"), 10);

    }

    private void loadInitTimeData() {
        for (String line : InitConstants.LINE_LIST) {
            timePathRepository
                .addNewLine(lineRepository.findByName(line), InitConstants.SECTION_LIST.get(line));
        }

        timePathRepository.addEdgeWeight(
            lineRepository.findByName("2호선"),
            stationRepository.findByName("교대역"),
            stationRepository.findByName("강남역"), 3);

        timePathRepository.addEdgeWeight(
            lineRepository.findByName("2호선"),
            stationRepository.findByName("강남역"),
            stationRepository.findByName("역삼역"), 3);

        timePathRepository.addEdgeWeight(
            lineRepository.findByName("3호선"),
            stationRepository.findByName("교대역"),
            stationRepository.findByName("남부터미널역"), 2);

        timePathRepository.addEdgeWeight(
            lineRepository.findByName("3호선"),
            stationRepository.findByName("남부터미널역"),
            stationRepository.findByName("양재역"), 5);

        timePathRepository.addEdgeWeight(
            lineRepository.findByName("3호선"),
            stationRepository.findByName("양재역"),
            stationRepository.findByName("매봉역"), 1);

        timePathRepository.addEdgeWeight(
            lineRepository.findByName("신분당선"),
            stationRepository.findByName("강남역"),
            stationRepository.findByName("양재역"), 8);

        timePathRepository.addEdgeWeight(
            lineRepository.findByName("신분당선"),
            stationRepository.findByName("양재역"),
            stationRepository.findByName("양재시민의숲역"), 3);

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
