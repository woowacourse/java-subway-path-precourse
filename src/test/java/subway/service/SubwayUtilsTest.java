package subway.service;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import subway.domain.LineRepository;

public class SubwayUtilsTest {

    @Test
    @DisplayName("초기 설정 테스트")
    public void initialize() {

        // when
        LineRepository repository = SubwayUtils.initialize();

        //then
        assertThat(repository.lines().get(0).getLineDirection().getStationNames())
                .containsExactly("교대역", "강남역", "역삼역");
    }

    @Test
    @DisplayName("최단 경로 테스트")
    public void findShortenPathByDistance() {

        // given
        SubwayUtils.initGraph();

        // when
        List<String> stations = SubwayUtils.findShortenPathByDistance("교대역", "양재역");

        //then
        assertThat(stations).containsExactly("교대역", "강남역", "양재역");
    }

    @Test
    @DisplayName("최소 시간 테스트")
    public void findShortenPathByTime() {

        // given
        SubwayUtils.initGraph();

        // when
        List<String> stations = SubwayUtils.findShortenPathByTime("교대역", "양재역");

        //then
        assertThat(stations).containsExactly("교대역", "남부터미널역", "양재역");
    }
}
