package subway.domain.line.service;

import subway.domain.line.domain.Line;
import subway.domain.line.domain.LineRepository;
import subway.domain.line.dto.SectionInsertRequestDto;
import subway.domain.station.domain.Station;
import subway.domain.station.domain.StationRepository;

public class LineStationService {

    public static void addSection(SectionInsertRequestDto requestDto) {
        Line line = LineRepository.findByName(requestDto.getLineName());
        Station station = StationRepository.findByName(requestDto.getStationName());
        line.addSection(station, requestDto.getDistance(), requestDto.getTime());
    }
}
