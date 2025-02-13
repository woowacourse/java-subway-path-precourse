package subway.application.section.dto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import subway.domain.line.LineDTO;
import subway.domain.station.StationDTO;

public class SectionDTOTest {
    @Test
    public void constructor__SectionAddingLineInfoEssentialException() {
        StationDTO sourceDTO = new StationDTO("source");
        StationDTO sinkDTO = new StationDTO("sink");
        String message = "구간 생성시 노선 정보는 필수입니다.";
        assertThatThrownBy(() -> new SectionDTO(null, sourceDTO, sinkDTO)).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(message);
    }

    @Test
    public void constructor__SectionAddingSourceStationInfoEssentialException() {
        LineDTO lineDTO = new LineDTO("line");
        StationDTO sinkDTO = new StationDTO("sink");
        String message = "구간 생성시 시작역 정보는 필수입니다.";
        assertThatThrownBy(() -> new SectionDTO(lineDTO, null, sinkDTO)).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(message);
    }

    @Test
    public void constructor__SectionAddingSinkStationInfoEssentialException() {
        LineDTO lineDTO = new LineDTO("line");
        StationDTO sourceDTO = new StationDTO("source");
        String message = "구간 생성시 종료역 정보는 필수입니다.";
        assertThatThrownBy(() -> new SectionDTO(lineDTO, sourceDTO, null)).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(message);
    }
}
