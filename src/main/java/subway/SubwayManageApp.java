package subway;

import subway.view.InputView;
import subway.view.OutputView;
import subway.view.screen.MainView;

public class SubwayManageApp {
    private final InputView inputView;
    private final OutputView outputView;

    public SubwayManageApp(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startApp() {
        MainView mainView = new MainView(outputView);
        mainView.showOptions();
    }
}
