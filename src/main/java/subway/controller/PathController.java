package subway.controller;

import subway.domain.entity.Section;
import subway.domain.entity.Station;
import subway.domain.entity.Stations;
import subway.dto.LineDto;
import subway.dto.SectionDto;
import subway.service.LineService;
import subway.service.StationService;

public class PathController {

    private final StationService stationService;
    private final LineService lineService;

    public PathController(StationService stationService, LineService lineService) {
        this.stationService = stationService;
        this.lineService = lineService;
    }

    public void addLine(LineDto lineDto, SectionDto sectionDto) {
        String upwardLastStationName = lineDto.getUpwardLastStationName();
        String nextStationName = lineDto.getNextStationName();
        Section section = sectionDto.toEntity();
        Stations stations = stationService.generateStations(upwardLastStationName, nextStationName, section);
        String lineName = lineDto.getLineName();
        lineService.addLine(lineName, stations);
    }

    public void addStationAtLine(LineDto lineDto, SectionDto sectionDto) {
        String stationName = lineDto.getNextStationName();
        String lineName = lineDto.getLineName();
        Section section = sectionDto.toEntity();
        Station station = stationService.findStationByName(stationName);
        lineService.addStationAtLine(lineName, station, section);
    }
}
