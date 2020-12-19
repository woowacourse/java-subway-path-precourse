package subway.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SectionRepositoryTest {

    @Test
    public void 구간_등록() {
        // given
        Station station1 = new Station("교대역");
        Station station2 = new Station("강남역");
        Station station3 = new Station("역삼역");
        SectionRepository.addSection(station1, station2, 2, 3);
        SectionRepository.addSection(station2, station3, 2, 3);

        // when


        // then
    }

}