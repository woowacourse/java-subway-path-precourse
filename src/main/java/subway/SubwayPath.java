package subway;

import subway.view.InputView;
import subway.view.OutputView;

public class SubwayPath {
    private InputView inputView;

    public SubwayPath(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        while (true) {
            OutputView.showMainOption();
            break;
        }
    }
}
