package subway.controller;

import subway.domain.MainAction;
import subway.domain.PathAction;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayController {
    public void run(InputView inputView) {
        while(true) {
            OutputView.printMain();
            if (MainAction.isFinish(inputView.receiveAction())) {
                break;
            }

            OutputView.printPathAction();
            if (PathAction.isBack(inputView.receiveAction())) {
                break;
            }
        }
    }
}
