package subway.service;

import subway.view.InputView;
import subway.view.OutputView;

public class MainService {
    public static final String TO_ROUTE_SEARCH_SERVICE_CODE = "1";
    public static final String END_SERVICE = "Q";
    public static final String ERR_IMPROPER_INPUT_CODE = "잘못된 입력값입니다.";

    public static void main() {
        try {
            view();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            main();
        }
    }

    public static void view() {
        OutputView.printMainView();
        String answer = InputView.getAnswer();
        if (answer.equals(TO_ROUTE_SEARCH_SERVICE_CODE)) {
            RouteSearchService.main();
            view();
        }
        if (answer.equals(END_SERVICE)) {
            return;
        }
        throw new IllegalArgumentException(ERR_IMPROPER_INPUT_CODE);
    }
}
