package subway.controller;

import subway.domain.SearchType;
import subway.dto.ShortestPathDto;
import subway.service.PathService;
import subway.view.InputView;
import subway.view.OutputView;

public class PathController {
    private static final String START = "시작";
    private static final String END = "도착";

    private final InputView inputView;
    private final PathService pathService;

    public PathController(InputView inputView) {
        this.inputView = inputView;
        pathService = new PathService();
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
        String startStationName = inputView.inputStationName(START);
        String endStationName =   inputView.inputStationName(END);
        ShortestPathDto shortestPathDto = pathService.calcShortestPath(startStationName, endStationName, searchType);
        OutputView.printResult(shortestPathDto);
    }
}
