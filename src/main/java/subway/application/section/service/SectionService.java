package subway.application.section.service;

import java.util.List;

import org.jgrapht.GraphPath;
import org.jgrapht.graph.DefaultWeightedEdge;

import subway.application.section.dto.SectionDTO;
import subway.application.section.dto.ShortCostRequest;
import subway.application.section.dto.ShortCostResponse;
import subway.domain.line.Line;
import subway.domain.line.LineService;
import subway.domain.section.Section;
import subway.domain.section.SectionRepository;
import subway.domain.station.Station;
import subway.domain.station.StationDTO;
import subway.domain.station.StationService;

public class SectionService {
    private static final String ALREADY_EXISTS_SECTION_MESSAGE = "이미 등록되어있는 구간입니다.";
    private static final String NOT_EXISTS_SOURCE_STATION_MESSAGE = "존재하지 않은 시작역입니다.";
    private static final String NOT_EXISTS_SINK_STATION_MESSAGE = "존재하지 않은 종료역입니다.";
    private static final String NOT_CONNECTED_SOURCE_AND_SINK_STATION_MESSAGE = "시작 지점과 종료역이 연결되어 있지 않습니다.";

    private final LineService lineService = new LineService();
    private final StationService stationService = new StationService();
    private final ShortDistanceService shortDistanceService = new ShortDistanceService();
    private final ShortTimeService shortTimeService = new ShortTimeService();

    public List<Section> findAll() {
        return SectionRepository.sections();
    }

    public void addNode(StationDTO stationDTO) {
        Station station = this.stationService.findOneByName(stationDTO.getName());
        this.shortDistanceService.addNode(station);
        this.shortTimeService.addNode(station);
    }

    public void addSection(SectionDTO sectionDTO) {
        Line line = this.lineService.findOneByName(sectionDTO.getLineDTO().getName());
        Station source = this.stationService.findOneByName(sectionDTO.getSourceDTO().getName());
        Station sink = this.stationService.findOneByName(sectionDTO.getSinkDTO().getName());
        Section section = new Section(line, source, sink, sectionDTO.getDistance(), sectionDTO.getTime());
        if (SectionRepository.exists(section)) {
            throw new IllegalArgumentException(ALREADY_EXISTS_SECTION_MESSAGE);
        }
        SectionRepository.addSection(section);
        this.shortDistanceService.addEdge(section);
        this.shortTimeService.addEdge(section);
        line.addSection(section);
        source.addSection(section);
    }

    public ShortCostResponse computeShortDistance(ShortCostRequest shortCostRequest) {
        Station source = this.stationService.findByName(shortCostRequest.getSourceDTO().getName())
            .orElseThrow(() -> new IllegalArgumentException(NOT_EXISTS_SOURCE_STATION_MESSAGE));
        Station sink = this.stationService.findByName(shortCostRequest.getSinkDTO().getName())
            .orElseThrow(() -> new IllegalArgumentException(NOT_EXISTS_SINK_STATION_MESSAGE));
        GraphPath<Station, DefaultWeightedEdge> graphPath = this.shortDistanceService.compute(source, sink);
        if (graphPath == null) {
            throw new IllegalArgumentException(NOT_CONNECTED_SOURCE_AND_SINK_STATION_MESSAGE);
        }
        return new ShortCostResponse(graphPath.getVertexList());
    }

    public ShortCostResponse computeShortTime(ShortCostRequest shortCostRequest) {
        Station source = this.stationService.findByName(shortCostRequest.getSourceDTO().getName())
            .orElseThrow(() -> new IllegalArgumentException(NOT_EXISTS_SOURCE_STATION_MESSAGE));
        Station sink = this.stationService.findByName(shortCostRequest.getSinkDTO().getName())
            .orElseThrow(() -> new IllegalArgumentException(NOT_EXISTS_SINK_STATION_MESSAGE));
        GraphPath<Station, DefaultWeightedEdge> graphPath = this.shortDistanceService.compute(source, sink);
        if (graphPath == null) {
            throw new IllegalArgumentException(NOT_CONNECTED_SOURCE_AND_SINK_STATION_MESSAGE);
        }
        return new ShortCostResponse(graphPath.getVertexList());
    }

    public void deleteAll() {
        SectionRepository.deleteAll();
    }
}
