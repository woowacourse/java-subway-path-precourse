package subway.application.section.service;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import subway.application.section.dto.SectionDTO;
import subway.application.section.dto.ShortCostRequest;
import subway.application.section.dto.ShortCostResponse;
import subway.domain.line.Line;
import subway.domain.line.LineDTO;
import subway.domain.line.LineService;
import subway.domain.station.Station;
import subway.domain.station.StationDTO;
import subway.domain.station.StationService;

public class SectionServiceTest {
    private final LineDTO lineDTO = new LineDTO("line");
    private final StationDTO sourceDTO = new StationDTO("source");
    private final StationDTO sinkDTO = new StationDTO("sink");

    private final LineService lineService = new LineService();
    private final StationService stationService = new StationService();
    private final SectionService sectionService = new SectionService();
    private final ShortDistanceService shortDistanceService = new ShortDistanceService();
    private final ShortTimeService shortTimeService = new ShortTimeService();

    @BeforeEach
    public void setup() {
        this.lineService.addLine(lineDTO);
        this.stationService.addStation(sourceDTO);
        this.stationService.addStation(sinkDTO);
    }

    @Test
    public void addSection() {
        Line line = this.lineService.findOneByName(lineDTO.getName());
        Station source = this.stationService.findOneByName(sourceDTO.getName());
        SectionDTO sectionDTO = new SectionDTO(lineDTO, sourceDTO, sinkDTO);
        assertThat(this.sectionService.findAll()).hasSize(0);
        assertThat(line.getSectionList()).hasSize(0);
        assertThat(source.getSectionList()).hasSize(0);
        this.sectionService.addNode(this.sourceDTO);
        this.sectionService.addNode(this.sinkDTO);
        this.sectionService.addSection(sectionDTO);
        assertThat(this.sectionService.findAll()).hasSize(1);
        assertThat(line.getSectionList()).hasSize(1);
        assertThat(source.getSectionList()).hasSize(1);
    }

    @Test
    public void addSection__AlreadyExistsSectionException() {
        SectionDTO sectionDTO = new SectionDTO(lineDTO, sourceDTO, sinkDTO);
        String message = "이미 등록되어있는 구간입니다.";
        this.sectionService.addNode(this.sourceDTO);
        this.sectionService.addNode(this.sinkDTO);
        this.sectionService.addSection(sectionDTO);
        assertThatThrownBy(() -> this.sectionService.addSection(sectionDTO)).isInstanceOf(
                IllegalArgumentException.class)
            .hasMessage(message);
    }

    @Test
    public void computeShortDistance() {
        int distance = 1;
        int time = 8;
        SectionDTO sectionDTO = new SectionDTO(this.lineDTO, this.sourceDTO, this.sinkDTO, distance, time);
        ShortCostRequest shortCostRequest = new ShortCostRequest(this.sourceDTO, this.sinkDTO);
        this.sectionService.addNode(this.sourceDTO);
        this.sectionService.addNode(this.sinkDTO);
        this.sectionService.addSection(sectionDTO);
        ShortCostResponse shortCostResponse = this.sectionService.computeShortDistance(shortCostRequest);
        assertThat(shortCostResponse.getTotalDistance()).isEqualTo(distance);
        assertThat(shortCostResponse.getTotalTime()).isEqualTo(time);
        assertThat(shortCostResponse.getStationNameList()).containsExactly(this.sourceDTO.getName(),
            this.sinkDTO.getName());
    }

    @Test
    public void computeShortDistance__NotExistsSourceStationException() {
        StationDTO otherDTO = new StationDTO("other");
        ShortCostRequest shortCostRequest = new ShortCostRequest(otherDTO, this.sinkDTO);
        String message = "존재하지 않은 시작역입니다.";
        assertThatThrownBy(() -> this.sectionService.computeShortDistance(shortCostRequest)).isInstanceOf(
            IllegalArgumentException.class).hasMessage(message);
    }

    @Test
    public void computeShortDistance__NotExistsSinkStationException() {
        StationDTO otherDTO = new StationDTO("other");
        ShortCostRequest shortCostRequest = new ShortCostRequest(this.sourceDTO, otherDTO);
        String message = "존재하지 않은 종료역입니다.";
        assertThatThrownBy(() -> this.sectionService.computeShortDistance(shortCostRequest)).isInstanceOf(
            IllegalArgumentException.class).hasMessage(message);
    }

    @Test
    public void computeShortDistance__NotConnectedSourceAndSinkStationException() {
        ShortCostRequest shortCostRequest = new ShortCostRequest(this.sourceDTO, this.sinkDTO);
        String message = "시작 지점과 종료역이 연결되어 있지 않습니다.";
        this.sectionService.addNode(this.sourceDTO);
        this.sectionService.addNode(this.sinkDTO);
        assertThatThrownBy(() -> this.sectionService.computeShortDistance(shortCostRequest)).isInstanceOf(
            IllegalArgumentException.class).hasMessage(message);
    }

    @AfterEach
    public void init() {
        this.lineService.deleteAll();
        this.stationService.deleteAll();
        this.sectionService.deleteAll();
        this.shortDistanceService.deleteAll();
        this.shortTimeService.deleteAll();
    }
}
