package subway.domain.section;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class RunTimeTest {

    @DisplayName("소요시간 객체를 생성하는 기능을 테스트한다")
    @Test
    void testInitRunTime() {
        //given
        int runTimeValue = 1;

        //when
        RunTime runTime = new RunTime(runTimeValue);

        //then
        assertThat(runTime).extracting("runTime").isEqualTo(runTimeValue);
    }

    @DisplayName("소요시간의 소요시간 값이 양수가 아니면 예외를 발생하는 기능을 테스트한다")
    @ParameterizedTest
    @ValueSource(ints = {
            0, -1, -2, -3, -4
    })
    void testInitRunTimeIfRunTimeValueIsNotPositiveNumber(int runTimeValue) {
        //when //then
        assertThatThrownBy(() -> new RunTime(runTimeValue))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
