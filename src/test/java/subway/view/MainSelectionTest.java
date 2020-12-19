package subway.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.exception.ErrorCode;
import subway.exception.SelectionException;
import subway.view.selection.MainSelection;

import static org.assertj.core.api.Assertions.*;

class MainSelectionTest {

    @Test
    @DisplayName("메인 옵션 선택시 보장된 입력 값만 입력해야한다.")
    void testInput() {
        //given
        String inputOne = "1";
        String inputQuit = "Q";

        //when
        MainSelection mainSelectionOne = new MainSelection(inputOne);
        MainSelection mainSelectionQuit = new MainSelection(inputQuit);

        //then
        assertThat(mainSelectionOne.getOption()).isEqualTo(inputOne);
        assertThat(mainSelectionQuit.getOption()).isEqualTo(inputQuit);
    }

    @Test
    @DisplayName("메인 옵션 선택시 보장되지 않은 입력 값일 시 에러가 발생한다.")
    void testInputError() {
        //given
        String inputWrong = "2";
        String inputWrong2 = "0";

        //then
        assertThatThrownBy(() -> new MainSelection(inputWrong))
                .isInstanceOf(SelectionException.class)
                .hasMessage(ErrorCode.INVALID_INPUT_VALUE.getMessage());
        assertThatThrownBy(() -> new MainSelection(inputWrong2))
                .isInstanceOf(SelectionException.class)
                .hasMessage(ErrorCode.INVALID_INPUT_VALUE.getMessage());

    }
}