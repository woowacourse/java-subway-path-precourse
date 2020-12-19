package subway.controller;

import subway.view.InputView;
import subway.view.OutputView;

public abstract class SubwayController {

    private InputView inputView;
    private OutputView outputView;

    public SubwayController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public InputView getInputView() {
        return inputView;
    }

    public OutputView getOutputView() {
        return outputView;
    }

    public abstract void start();
}