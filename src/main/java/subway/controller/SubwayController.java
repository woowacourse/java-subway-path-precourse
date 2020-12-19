package subway.controller;

import subway.domain.MainAction;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayController {
    public void run(InputView inputView) {
        OutputView.printMain();
        System.out.println(MainAction.isFinish(inputView.receiveAction()));
    }
}
