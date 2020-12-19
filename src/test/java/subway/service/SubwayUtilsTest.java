package subway.service;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SubwayUtilsTest {

    @Test
    @DisplayName("초기 설정 테스트")
    public void initialize() {

        // when
        SubwayService subwayService = SubwayUtils.initialize();

        //then
        assertThat(subwayService.getLineRepository().lines().get(0).getLineDirection().getStationNames())
                .containsExactly("교대역", "강남역", "역삼역");
    }

    @Test
    @DisplayName("최단 경로 테스트")
    public void findShortenPath() {

        // given
        SubwayUtils.initGraph();

        // when
        List<String> stations = SubwayUtils.findShortenPath("교대역", "양재역");

        //then
        assertThat(stations).containsExactly("교대역", "강남역", "양재역");
    }
}
