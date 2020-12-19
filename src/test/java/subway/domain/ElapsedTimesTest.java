package subway.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ElapsedTimesTest {

    @Test
    @DisplayName("소요 시간들을 입력받아 ElapsedTime 일급 컬렉션 객체 생성 테스트")
    public void create_ElapsedList_NewInstance() {

        // when
        ElapsedTimes elapsedTimes = new ElapsedTimes(1, 2, 3);

        //then
        assertThat(elapsedTimes.getTimes()).extracting(ElapsedTime::getTime)
                .containsExactly(1, 2, 3);
    }
}
