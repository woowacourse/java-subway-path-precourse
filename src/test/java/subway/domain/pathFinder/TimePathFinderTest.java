package subway.domain.pathFinder;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.jgrapht.GraphPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import subway.domain.Station;
import subway.domain.repository.RepositoryConfig;
import subway.domain.repository.StationRepository;

class TimePathFinderTest {
    TimePathFinder pathFinder;

    @BeforeEach
    void initRepository(){
        RepositoryConfig.initRepository();
        pathFinder = new TimePathFinder();
    }

    @ParameterizedTest
    @CsvSource({"교대역,양재역,7,2",
    "강남역,매봉역,9,2"})
    void 정상_결과_테스트(String startName, String endName, int time, int length){
        Station start = StationRepository.getStationByName(startName);
        Station end = StationRepository.getStationByName(endName);
        GraphPath<Station, DefaultWeightedEdge> path = pathFinder.findPath(start, end);
        System.out.println(path.getVertexList());
        Assertions.assertThat(path.getWeight())
                .isEqualTo(time);
        Assertions.assertThat(path.getLength())
                .isEqualTo(length);
    }

    /*
     */
}