package subway.path;

import subway.view.InputView;
import subway.view.OutputView;

public class PathController {
    private InputView inputView;

    public PathController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        while (true) {
            OutputView.showSearchPathMethod();
            break;
        }
    }
}
