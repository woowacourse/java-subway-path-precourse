package subway.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import subway.domain.StationRepository;

import static org.assertj.core.api.Assertions.*;

class StationServiceTests {
    private StationService stationService;

    @BeforeEach
    public void 초기화() {
        stationService = new StationService();
    }

    @ParameterizedTest
    @ValueSource(strings = {"교대역", "역삼역"})
    public void 등록_성공(String name) {

        assertThatCode(() -> stationService.addStation(name))
                .doesNotThrowAnyException();

        assertThat(StationRepository.isExistent(name))
                .isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"역", "역ㅁ", "station"})
    public void 등록_실패_이름_포맷_이상(String name) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> stationService.addStation(name));
    }

    @Test
    public void 등록_실패_중복된_이름() {
        String name = "판교";

        assertThatCode(() -> stationService.addStation(name))
                .doesNotThrowAnyException();

        assertThatIllegalArgumentException()
                .isThrownBy(() -> stationService.addStation(name));
    }
}