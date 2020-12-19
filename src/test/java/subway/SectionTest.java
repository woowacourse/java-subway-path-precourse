package subway;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.DataInitializer;
import subway.domain.Section;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.Arrays;
import java.util.HashSet;

public class SectionTest {
    static {
        DataInitializer.initialize();
    }

    @DisplayName("출력을 통한 생성 확인 테스트")
    @Test
    public void creationTest() {

        Section section;
        section = new Section(new HashSet<Station>(Arrays.asList(
                StationRepository.searchByName("교대역"),
                StationRepository.searchByName("강남역")
        )), 3, 2);
        System.out.println(section);
    }

}
