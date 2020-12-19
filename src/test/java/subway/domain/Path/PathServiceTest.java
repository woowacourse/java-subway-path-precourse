package subway.domain.Path;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.DummyData;
import subway.domain.Path.dto.PathResponseDto;
import subway.domain.Path.exception.NotConnectedException;
import subway.domain.Path.exception.SameStartAndEndStationException;
import subway.domain.Path.service.PathService;
import subway.domain.station.domain.StationRepository;
import subway.domain.station.dto.StationRequestDto;
import subway.domain.station.exception.CannotFindStationByNameException;
import subway.domain.station.service.StationService;

class PathServiceTest {

    @BeforeAll
    static void beforeAll() {
        DummyData.load();
    }

    @DisplayName("출발역과 도착역을 입력받아 최단 거리 경로를 조회한다.")
    @Test
    void getShortestDistanceRoute() {
        final String sourceStationName = "교대역";
        final String targetStationName = "양재역";

        PathResponseDto responseDto = PathService.getShortestDistanceGraphPath(sourceStationName, targetStationName);

        assertEquals(responseDto.getTotalWeight(), 4);
    }

    @DisplayName("출발역과 도착역을 입력받아 최소 시간 경로를 조회한다.")
    @Test
    void getShortestTimeRoute() {
        final String sourceStationName = "교대역";
        final String targetStationName = "양재역";

        PathResponseDto responseDto = PathService.getShortestTimeGraphPath(sourceStationName, targetStationName);

        assertEquals(responseDto.getTotalWeight(), 7);
    }

    @DisplayName("경로 조회 시 출발역이나 도착역이 존재하지 않으면 에러를 출력한다.")
    @Test
    void cannotFindStationByNameException() {
        final String sourceStationName = "평양역";
        final String targetStationName = "서귀포역";

        assertThrows(CannotFindStationByNameException.class,
            () -> PathService.getShortestDistanceGraphPath(sourceStationName, targetStationName));
    }

    @DisplayName("경로 조회 시 출발역과 도착역이 같으면 에러를 출력한다.")
    @Test
    void sameStartAndEndStationException() {
        final String sourceStationName = "교대역";
        final String targetStationName = "교대역";

        assertThrows(SameStartAndEndStationException.class,
            () -> PathService.getShortestDistanceGraphPath(sourceStationName, targetStationName));
    }

    @DisplayName("경로 조회 시 출발역과 도착역이 연결되어 있지 않으면 에러를 출력한다.")
    @Test
    void notConnectedException() {
        final String sourceStationName = "교대역";
        final String targetStationName = "새로운역";
        StationService.save(new StationRequestDto(targetStationName));

        assertThrows(NotConnectedException.class,
            () -> PathService.getShortestDistanceGraphPath(sourceStationName, targetStationName));
    }
}