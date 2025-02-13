package subway.presentation;

import subway.application.section.dto.SectionDTO;
import subway.application.section.dto.ShortCostRequest;
import subway.application.section.dto.ShortCostResponse;
import subway.application.section.service.SectionService;
import subway.domain.line.LineDTO;
import subway.domain.station.StationDTO;
import subway.util.Validation;

public class SectionController {
    private static final String INPUT_ESSENTIAL_DISTANCE_MESSAGE = "거리 입력은 필수입니다.";
    private static final String ONLY_POSSIBLE_NUMERIC_INPUT_DISTANCE_MESSAGE = "거리는 숫자 형식의 입력만 가능합니다.";
    private static final String INPUT_ESSENTIAL_TIME_MESSAGE = "시간 입력은 필수입니다.";
    private static final String ONLY_POSSIBLE_NUMERIC_INPUT_TIME_MESSAGE = "시간은 숫자 형식의 입력만 가능합니다.";

    private final SectionService sectionService = new SectionService();

    public void addSection(String lineName, String sourceName, String sinkName, String _distance, String _time) {
        LineDTO lineDTO = new LineDTO(lineName);
        StationDTO sourceDTO = new StationDTO(sourceName);
        StationDTO sinkDTO = new StationDTO(sinkName);
        this.validateDistance(_distance);
        int distance = Integer.parseInt(_distance);
        this.validateTime(_time);
        int time = Integer.parseInt(_time);
        SectionDTO sectionDTO = new SectionDTO(lineDTO, sourceDTO, sinkDTO, distance, time);
        this.sectionService.addSection(sectionDTO);
    }

    private void validateDistance(String distance) {
        if (distance == null || distance.trim().isEmpty()) {
            throw new IllegalArgumentException(INPUT_ESSENTIAL_DISTANCE_MESSAGE);
        }
        if (!Validation.isNumeric(distance)) {
            throw new IllegalArgumentException(ONLY_POSSIBLE_NUMERIC_INPUT_DISTANCE_MESSAGE);
        }
    }

    private void validateTime(String time) {
        if (time == null || time.trim().isEmpty()) {
            throw new IllegalArgumentException(INPUT_ESSENTIAL_TIME_MESSAGE);
        }
        if (!Validation.isNumeric(time)) {
            throw new IllegalArgumentException(ONLY_POSSIBLE_NUMERIC_INPUT_TIME_MESSAGE);
        }
    }

    public ShortCostResponse computeShortDistance(String sourceName, String sinkName) {
        ShortCostRequest shortCostRequest = this.createShortCostRequest(sourceName, sinkName);
        return this.sectionService.computeShortDistance(shortCostRequest);
    }

    public ShortCostResponse computeShortTime(String sourceName, String sinkName) {
        ShortCostRequest shortCostRequest = this.createShortCostRequest(sourceName, sinkName);
        return this.sectionService.computeShortTime(shortCostRequest);
    }

    private ShortCostRequest createShortCostRequest(String sourceName, String sinkName) {
        StationDTO sourceDTO = new StationDTO(sourceName);
        StationDTO sinkDTO = new StationDTO(sinkName);
        return new ShortCostRequest(sourceDTO, sinkDTO);
    }
}
