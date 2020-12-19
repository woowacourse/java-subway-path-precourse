package subway;

import subway.view.MainViewState;
import subway.view.RouteLookupViewState;
import subway.view.ViewState;

import java.util.Scanner;

public class SubwayPath {
    private ViewState viewState;

    public SubwayPath(Scanner scanner) {
        MainViewState.initializeMainView(scanner);
        RouteLookupViewState.initializeRouteLookupView(scanner);
        viewState = MainViewState.getMainView();
    }

    public void setViewState(ViewState viewState) {
        this.viewState = viewState;
    }

    public void run() {
        boolean isContinuing = true;
        while (isContinuing) {
            isContinuing = viewState.render(this);
        }
    }
}
