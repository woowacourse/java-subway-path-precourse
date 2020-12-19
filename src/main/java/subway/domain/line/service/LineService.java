package subway.domain.line.service;

import subway.domain.line.domain.Line;
import subway.domain.line.domain.LineRepository;
import subway.domain.line.dto.LineRequestDto;
import subway.domain.station.domain.Station;
import subway.domain.station.domain.StationRepository;

public class LineService {

    public static void save(LineRequestDto requestDto) {
        Station upstreamStation = StationRepository.findByName(requestDto.getUpstreamStationName());
        Station downstreamStation = StationRepository.findByName(requestDto.getDownstreamStationName());
        Line newLine = Line
            .of(requestDto.getName(), upstreamStation, downstreamStation,
                requestDto.getDistance(), requestDto.getTime());
        LineRepository.save(newLine);
    }

    public static boolean contains(Station targetStation) {
        return LineRepository.findAll().stream()
            .anyMatch(line -> line.contains(targetStation));
    }
}
