package subway;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.DataInitializer;
import subway.domain.StationRepository;
import subway.domain.TimeGraph;
import subway.dto.PathDTO;

public class TimeGraphTest {
    static {
        DataInitializer.initialize();
    }

    @DisplayName("최단 경로 출력 테스트")
    @Test
    public void timePathTest() {
        PathDTO pathDTO = TimeGraph.getShortestPath(
                StationRepository.searchByName("교대역"),
                StationRepository.searchByName("양재역")
        );

        for (String name : pathDTO.getStationsNameList()) {
            System.out.println(name);
        }

        System.out.println(pathDTO.getTime());

    }
}
