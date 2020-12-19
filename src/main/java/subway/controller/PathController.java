package subway.controller;

import subway.domain.entity.Section;
import subway.domain.entity.Station;
import subway.domain.entity.Stations;
import subway.domain.path.SubwayGraph;
import subway.dto.LineDto;
import subway.dto.PathRequestDto;
import subway.dto.PathResponseDto;
import subway.dto.SectionDto;
import subway.service.LineService;
import subway.service.StationService;
import subway.type.FunctionType;

public class PathController {

    private final SubwayGraph subwayGraph = SubwayGraph.getInstance();

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

    public PathResponseDto findShortestPath(FunctionType functionType, PathRequestDto pathRequestDto) {
        String firstStationName = pathRequestDto.getFirstStationName();
        String lastStationName = pathRequestDto.getLastStationName();
        Station firstStation = StationService.findStationByName(firstStationName);
        Station lastStation = StationService.findStationByName(lastStationName);
        return subwayGraph.findShortestPath(firstStation, lastStation, functionType);
    }
}
