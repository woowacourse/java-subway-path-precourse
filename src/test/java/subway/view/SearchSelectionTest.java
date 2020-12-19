package subway.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.exception.ErrorCode;
import subway.exception.SelectionException;
import subway.view.selection.SearchSelection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SearchSelectionTest {

    @Test
    @DisplayName("메인 옵션 선택시 보장된 입력 값만 입력해야한다.")
    void testInput() {
        //given
        String inputOne = "1";
        String input2 = "2";
        String input3 = "B";
        String input4 = "b";

        //when
        SearchSelection searchSelection = new SearchSelection(inputOne);
        SearchSelection searchSelection2 = new SearchSelection(input2);
        SearchSelection searchSelection3 = new SearchSelection(input3);
        SearchSelection searchSelection4 = new SearchSelection(input4);

        //then
        assertThat(searchSelection.getOption()).isEqualTo(inputOne);
        assertThat(searchSelection2.getOption()).isEqualTo(input2);
        assertThat(searchSelection3.getOption()).isEqualTo(input3);
        assertThat(searchSelection4.getOption()).isEqualTo(input4);
    }

    @Test
    @DisplayName("메인 옵션 선택시 보장되지 않은 입력 값일 시 에러가 발생한다.")
    void testInputError() {
        //given
        String inputWrong = "3";
        String inputWrong2 = "-b";

        //then
        assertThatThrownBy(() -> new SearchSelection(inputWrong))
                .isInstanceOf(SelectionException.class)
                .hasMessage(ErrorCode.INVALID_INPUT_VALUE.getMessage());
        assertThatThrownBy(() -> new SearchSelection(inputWrong2))
                .isInstanceOf(SelectionException.class)
                .hasMessage(ErrorCode.INVALID_INPUT_VALUE.getMessage());

    }
}