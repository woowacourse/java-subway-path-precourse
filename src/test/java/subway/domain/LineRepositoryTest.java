package subway.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import subway.util.Constants;

class LineRepositoryTest {

    private static final List<Line> lines = new ArrayList<>();

    private static final String NON_EXIST_LINE_NAME = "존재하지않는노선";

    @BeforeAll
    static void setUpBeforeAll() {
        Arrays.asList(Constants.INITIAL_LINE_NAMES)
            .forEach(lineName -> lines.add(new Line(lineName)));
    }

    @BeforeEach
    void setUp() {
        LineRepository.deleteAll();
        lines.forEach(LineRepository::addLine);
    }

    @Test
    void addLine_NameDuplicated_ExceptionThrown() {
        assertThatIllegalArgumentException().isThrownBy(() ->
            LineRepository.addLine(lines.get(0))
        );
    }

    @Test
    void addLine_ValidItem_NoExceptionThrown() {
        assertThatNoException().isThrownBy(() ->
            LineRepository.addLine(new Line(NON_EXIST_LINE_NAME))
        );
    }

    @Test
    void deleteLineByName_InvalidItem_False() {
        assertThat(LineRepository.deleteLineByName(NON_EXIST_LINE_NAME)).isFalse();
    }

    @Test
    void deleteLineByName_ValidItem_True() {
        assertThat(LineRepository.deleteLineByName(lines.get(0).getName())).isTrue();
    }

}
