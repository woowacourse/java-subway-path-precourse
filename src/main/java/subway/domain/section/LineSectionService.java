package subway.domain.section;

import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;

import java.util.LinkedList;
import java.util.List;

import static subway.domain.util.SetupConstant.*;

public class LineSectionService {

    void setUp() {
        LineSection lineSection2 = createLineSection(LINE_2, List.of(STATION_GYODAE, STATION_GANGNAM, STATION_YEOKSAM));
        LineSectionRepository.addLineSection(lineSection2);

        LineSection lineSection3 = createLineSection(LINE_3, List.of(STATION_GYODAE, STATION_NAMBU_TERMINAL, STATION_YANGJAE, STATION_MAEBONG));
        LineSectionRepository.addLineSection(lineSection3);

        LineSection lineSectionSinbundang = createLineSection(LINE_SINBUNDANG, List.of(STATION_GANGNAM, STATION_YANGJAE, STATION_YANGJAE_CITIZENS_FOREST));
        LineSectionRepository.addLineSection(lineSectionSinbundang);
    }

    LineSection createLineSection(String lineName, List<String> stationNames) {
        Line line = LineRepository.findByName(lineName);

        LinkedList<Station> stations = new LinkedList<>();
        for (String stationName : stationNames) {
            Station station = StationRepository.findByName(stationName);
            stations.add(station);
        }
        return new LineSection(line, stations);
    }

}