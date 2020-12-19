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
            .asList("## 메인 화면", "1. 경로 조회", "Q. 종료");
    private static final String SEARCH_ROUTE = "1";
    private static final String END = "Q";

    private RoutePage routePage;

    public MainPage() {
        routePage = new RoutePage();
    }

    public void start() {
        OutputView.printPage(mainPageItem);
        String button = InputView.inputFunctionButton();
        while (!button.equals(END)) {
            if (button.equals(SEARCH_ROUTE)) {
                routePage.start();
            }

            OutputView.printPage(mainPageItem);
            button = InputView.inputFunctionButton();
        }
    }
}
