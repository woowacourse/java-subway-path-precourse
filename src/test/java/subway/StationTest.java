package subway;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import subway.domain.StationRepository;
import subway.domain.exception.NoSuchStationException;


public class StationTest {

    @DisplayName("역 검색 테스트")
    @Test
    public void searchByNameTest() {
        assertThat(StationRepository.searchByName("강남역").getName()).isEqualTo("강남역");
    }

    @DisplayName("역 검색 오류 테스트")
    @Test
    public void searchByNameErrorTest() {
        assertThrows(NoSuchStationException.class, () -> StationRepository.searchByName("상도역"));
    }
}
