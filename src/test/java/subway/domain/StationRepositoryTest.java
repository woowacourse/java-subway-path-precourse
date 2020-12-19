package subway.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StationRepositoryTest {

    @Test
    public void 역_초기화_테스트(){
        assertThat("교대역").isEqualTo(StationRepository.stations()
                .get(0)
                .getName());
    }

}