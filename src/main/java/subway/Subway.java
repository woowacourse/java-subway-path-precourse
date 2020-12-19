package subway;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.SectionRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.util.InitConstants;
import subway.util.MessageUtils;

public class Subway {

    private final StationRepository stationRepository = new StationRepository();
    private final LineRepository lineRepository = new LineRepository();
    private final SectionRepository sectionRepository = new SectionRepository();

    public void launch(Scanner scanner) {
        loadInitStationData();
        loadInitLineData();
        loadInitSectionData();
        MessageUtils.printBlankLine();
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

    public SectionRepository getSectionRepository() {
        return sectionRepository;
    }


}
