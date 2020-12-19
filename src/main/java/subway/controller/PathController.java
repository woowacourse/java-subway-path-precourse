package subway.controller;

import subway.domain.entity.Section;
import subway.domain.entity.Station;
import subway.domain.entity.Stations;
import subway.dto.LineDto;
import subway.dto.SectionDto;
import subway.service.LineService;
import subway.service.StationService;

public class PathController {

    public void addLine(LineDto lineDto, SectionDto sectionDto) {
        String upwardLastStationName = lineDto.getUpwardLastStationName();
        String nextStationName = lineDto.getNextStationName();
        Section section = sectionDto.toEntity();
        Stations stations = StationService.generateStations(upwardLastStationName, nextStationName, section);
        String lineName = lineDto.getLineName();
        LineService.addLine(lineName, stations);
    }

    public void addStationAtLine(LineDto lineDto, SectionDto sectionDto) {
        String stationName = lineDto.getNextStationName();
        String lineName = lineDto.getLineName();
        Section section = sectionDto.toEntity();
        Station station = StationService.findStationByName(stationName);
        LineService.addStationAtLine(lineName, station, section);
    }
}
