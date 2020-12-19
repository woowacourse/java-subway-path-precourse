package subway.page;

import java.util.Arrays;
import java.util.List;
import subway.input.InputView;
import subway.output.OutputView;

/**
 * @author yhh1056
 * @since 2020/12/19
 */
public class MainPage {
    private static final List<String> mainPageItem = Arrays
            .asList("## 메인 화면", "1. 경로 조회");
    private static final String SEARCH_ROUTE = "1";

    public void start() {
        OutputView.printPage(mainPageItem);
        String button = InputView.inputFunctionButton();
        while (true) {
            if (button.equals(SEARCH_ROUTE)) {
                //todo: 경로 조회
            }
            //todo: 종료 버튼으로 종료
        }
    }
}
