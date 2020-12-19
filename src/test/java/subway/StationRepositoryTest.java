package subway;

import static org.assertj.core.api.Assertions.*;
import static resource.TextResource.ERROR_STATION_NAME_DUPLICATED;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.Station;
import subway.domain.StationRepository;

public class StationRepositoryTest {

    @BeforeAll
    public static void init() {
        Application.init();
    }

    @DisplayName("해당 지하철 역을 가지고 있는가?")
    @Test
    public void checkStationDuplicated() {
        assertThat(StationRepository.hasStation("없어요")).isFalse();
        assertThat(StationRepository.hasStation("강남역")).isTrue();
    }

    @DisplayName("중복된 지하철 역 이름은 등록 될 수 없다.")
    @Test
    public void checkAddStationPossible() {
        assertThatThrownBy(() -> {
            StationRepository.addStation(new Station("강남역"));
        }).isInstanceOf(IllegalArgumentException.class).hasMessage(ERROR_STATION_NAME_DUPLICATED);
    }
}
