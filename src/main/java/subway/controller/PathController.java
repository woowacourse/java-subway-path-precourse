package subway.controller;

import subway.domain.SearchType;
import subway.view.InputView;
import subway.view.OutputView;

public class PathController {
    private final InputView inputView;

    public PathController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        OutputView.printPathScreen(SearchType.getInfos());
    }
}
