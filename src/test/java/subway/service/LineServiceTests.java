package subway.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import subway.domain.LineRepository;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThat;

class LineServiceTests {
    private LineService lineService;

    @BeforeEach
    public void 초기화() {
        lineService = new LineService();
    }

    @ParameterizedTest
    @ValueSource(strings = {"2호선", "신분당선"})
    public void 등록_성공(String name) {
        assertThatCode(() -> lineService.addLine(name, Collections.emptyList()))
                .doesNotThrowAnyException();

        assertThat(LineRepository.isExistent(name))
                .isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"한", "노-선", "line"})
    public void 등록_실패_이름_포맷_이상(String name) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lineService.addLine(name, Collections.emptyList()));
    }

    @Test
    public void 등록_실패_중복된_이름() {
        String name = "3호선";

        assertThatCode(() -> lineService.addLine(name, Collections.emptyList()))
                .doesNotThrowAnyException();

        assertThatIllegalArgumentException()
                .isThrownBy(() -> lineService.addLine(name, Collections.emptyList()));
    }
}
