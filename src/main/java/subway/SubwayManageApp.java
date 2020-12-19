package subway;

import subway.view.InputView;
import subway.view.screen.SearchView;
import subway.view.selection.MainSelection;
import subway.view.OutputView;
import subway.view.selection.SearchSelection;
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
        while (true) {
            mainView.showOptions();
            MainSelection mainSelection = new MainSelection(inputView.inputNextLine());
            chooseOption(mainSelection);
            if (mainSelection.isQuit()) {
                break;
            }
        }
    }

    private void chooseOption(MainSelection mainSelection) {
        if (mainSelection.isOptionOne()) {
            manageSearch();
        }
    }

    private void manageSearch() {
        SearchView searchView = new SearchView(outputView);
        searchView.showOptions();
        SearchSelection searchSelection = new SearchSelection(inputView.inputNextLine());

    }
}
