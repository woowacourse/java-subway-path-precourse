package subway.application.section.dto;

import subway.domain.station.StationDTO;

public class ShortCostRequest {
    private static final String SOURCE_STATION_INFO_ESSENTIAL_MESSAGE = "시작역 정보는 필수입니다.";
    private static final String SINK_STATION_INFO_ESSENTIAL_MESSAGE = "종료역 정보는 필수입니다.";
    private static final String SAME_SOURCE_AND_SINK_STATION_MESSAGE = "출발역과 도착역이 동일합니다.";

    private final StationDTO sourceDTO;
    private final StationDTO sinkDTO;

    public ShortCostRequest(StationDTO sourceDTO, StationDTO sinkDTO) {
        this.validate(sourceDTO, sinkDTO);
        this.sourceDTO = sourceDTO;
        this.sinkDTO = sinkDTO;
    }

    private void validate(StationDTO sourceDTO, StationDTO sinkDTO) {
        if(sourceDTO == null) {
            throw new IllegalArgumentException(SOURCE_STATION_INFO_ESSENTIAL_MESSAGE);
        }
        if(sinkDTO == null) {
            throw new IllegalArgumentException(SINK_STATION_INFO_ESSENTIAL_MESSAGE);
        }
        if(sourceDTO.equals(sinkDTO)) {
            throw new IllegalArgumentException(SAME_SOURCE_AND_SINK_STATION_MESSAGE);
        }
    }

    public StationDTO getSourceDTO() {
        return sourceDTO;
    }

    public StationDTO getSinkDTO() {
        return sinkDTO;
    }
}
