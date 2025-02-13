package subway.application.section.dto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import subway.domain.station.StationDTO;

public class ShortCostRequestTest {
    @Test
    public void constructor__SourceStationInfoEssentialException() {
        StationDTO sinkDTO = new StationDTO("sink");
        String message = "시작역 정보는 필수입니다.";
        assertThatThrownBy(() -> new ShortCostRequest(null, sinkDTO)).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(message);
    }

    @Test
    public void constructor__SinkStationInfoEssentialException() {
        StationDTO sourceDTO = new StationDTO("source");
        String message = "종료역 정보는 필수입니다.";
        assertThatThrownBy(() -> new ShortCostRequest(sourceDTO, null)).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(message);
    }

    @Test
    public void constructor__SameSourceAndSinkStationException() {
        StationDTO sourceDTO = new StationDTO("same");
        StationDTO sinkDTO = new StationDTO("same");
        String message = "출발역과 도착역이 동일합니다.";
        assertThatThrownBy(() -> new ShortCostRequest(sourceDTO, sinkDTO)).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(message);
    }
}
