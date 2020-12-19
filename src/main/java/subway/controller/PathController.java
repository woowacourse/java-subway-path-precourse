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
        SearchType searchType = requestSearchNumber();
        runDetailAction(searchType);
    }

    private SearchType requestSearchNumber() {
        SearchType searchType = SearchType.BACK;

        while(true) {
            try {
                searchType = inputView.inputSearchNumber();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                OutputView.printPathScreen(SearchType.getInfos());
            }
        }

        return searchType;
    }

    private void runDetailAction(SearchType searchType) {
        
    }
}
