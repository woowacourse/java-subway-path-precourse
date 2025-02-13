package subway.application.section.dto;

import subway.domain.line.LineDTO;
import subway.domain.station.StationDTO;

public class SectionDTO {
    private static final String SECTION_ADDING_LINE_INFO_ESSENTIAL_MESSAGE = "구간 생성시 노선 정보는 필수입니다.";
    private static final String SECTION_ADDING_SOURCE_STATION_INFO_ESSENTIAL_MESSAGE = "구간 생성시 시작역 정보는 필수입니다.";
    private static final String SECTION_ADDING_SINK_STATION_INFO_ESSENTIAL_MESSAGE = "구간 생성시 종료역 정보는 필수입니다.";

    private final LineDTO lineDTO;
    private final StationDTO sourceDTO;
    private final StationDTO sinkDTO;
    private int distance;
    private int time;

    public SectionDTO(LineDTO lineDTO, StationDTO sourceDTO, StationDTO sinkDTO) {
        this(lineDTO, sourceDTO, sinkDTO, 0, 0);
    }

    public SectionDTO(LineDTO lineDTO, StationDTO sourceDTO, StationDTO sinkDTO, int distance, int time) {
        this.validate(lineDTO, sourceDTO, sinkDTO);
        this.lineDTO = lineDTO;
        this.sourceDTO = sourceDTO;
        this.sinkDTO = sinkDTO;
        this.distance = distance;
        this.time = time;
    }

    private void validate(LineDTO lineDTO, StationDTO sourceDTO, StationDTO sinkDTO) {
        if (lineDTO == null) {
            throw new IllegalArgumentException(SECTION_ADDING_LINE_INFO_ESSENTIAL_MESSAGE);
        }
        if (sourceDTO == null) {
            throw new IllegalArgumentException(SECTION_ADDING_SOURCE_STATION_INFO_ESSENTIAL_MESSAGE);
        }
        if (sinkDTO == null) {
            throw new IllegalArgumentException(SECTION_ADDING_SINK_STATION_INFO_ESSENTIAL_MESSAGE);
        }
    }

    public LineDTO getLineDTO() {
        return lineDTO;
    }

    public StationDTO getSourceDTO() {
        return sourceDTO;
    }

    public StationDTO getSinkDTO() {
        return sinkDTO;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
