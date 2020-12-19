package subway.page;

import java.util.Arrays;
import java.util.List;
import subway.input.InputView;
import subway.output.OutputView;

/**
 * @author yhh1056
 * @since 2020/12/19
 */
public class RoutePage {
    private static final List<String> routePageItem = Arrays
            .asList("\n## 경로 기준", "1. 최단 거리", "2. 최소 시간");
    private static final String SHORTEST_DISTANCE = "1";
    private static final String MINIMUM_TIME = "2";

    public void start() {
        OutputView.printPage(routePageItem);
        String button = InputView.inputFunctionButton();

        while (true) {
            if (button.equals(SHORTEST_DISTANCE)) {
                //todo: 최단 거리
            }
            if (button.equals(MINIMUM_TIME)) {
                //todo: 최소 시간
            }
        }
    }
}
