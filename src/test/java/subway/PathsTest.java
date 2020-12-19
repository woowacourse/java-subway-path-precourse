package subway;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.*;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static resource.TextResource.ERROR_ORDER_NOT_VALID;
import static resource.TextResource.ERROR_PATH_SIZE_OVER;

public class PathsTest {
    @BeforeAll
    public static void init() {
        Application.init();
    }
    @Test
    @DisplayName("노선에 구간 추가 시 입력 된 순서는 1 이상 노선에 등록된 역의 길이보다 1 작아야 한다.")
    public void checkPositionInPaths() {
        Line line = LineRepository.getLineByName("2호선");
        assertThatThrownBy(() -> {
            line.addPath(new Path(1,2), 5);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_ORDER_NOT_VALID);

        assertThatThrownBy(() -> {
            line.addPath(new Path(1,2), -1);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_ORDER_NOT_VALID);
    }
}
