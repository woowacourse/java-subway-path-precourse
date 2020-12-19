package subway.controller.path;

import subway.view.InputView;
import subway.view.OutputView;

public class QuickestPathController extends PathController {

    public QuickestPathController(InputView inputView) {
        super(inputView);
    }

    @Override
    public void run() {
        try {
            getStartingStation();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
        }
    }
}
