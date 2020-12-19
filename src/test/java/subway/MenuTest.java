package subway;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.exception.TransitRouteException;
import subway.menu.MainMenu;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MenuTest {
    @DisplayName("예외 : 잘못된 유저 입력이 들어왔을 경우")
    @Test
    void When_유저인풋잘못된입력_Expect_예외() {
        String testInput = "4";
        assertThatThrownBy(() -> MainMenu.findByCommand(testInput))
                .isInstanceOf(TransitRouteException.class)
                .hasMessage("[ERROR] 잘못 입력 하셨습니다");
    }
}
