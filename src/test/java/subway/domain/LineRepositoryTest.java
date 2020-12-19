package subway.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class LineRepositoryTest {

    @Test
    public void 노선_초기화_테스트(){
        assertThat("2호선").isEqualTo(LineRepository.lines().get(0).getName());
    }

    @Test
    public void 노선_역_초기화_테스트(){
        assertThat("교대역").isEqualTo(LineRepository.lines().get(0)
                .getStations()
                .get(0)
                .getName());
    }

}