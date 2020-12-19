package subway.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SubwayInitializerTest {

    @Test
    @DisplayName("초기 설정 테스트")
    public void initialize() {

        // when
        SubwayService subwayService = SubwayInitializer.initialize();

        //then
        assertThat(subwayService.getLineRepository().lines().get(0).getLineDirection().getStationNames())
                .containsExactly("교대역", "강남역", "역삼역");
    }
}
