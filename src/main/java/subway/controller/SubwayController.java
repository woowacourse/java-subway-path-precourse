package subway.controller;

import subway.domain.Result;
import subway.domain.Station;
import subway.service.MinimumTimeService;
import subway.service.ShortestPathService;
import subway.view.output.OutputView;

public class SubwayController {
    private final ShortestPathService shortestPathService;
    private final MinimumTimeService minimumTimeService;
    private OutputView outputView;

    private SubwayController(ShortestPathService shortestPathService, MinimumTimeService minimumTimeService,
                             OutputView outputView) {
        this.shortestPathService = shortestPathService;
        this.minimumTimeService = minimumTimeService;
        this.outputView = outputView;
    }

    public static SubwayController createSubwayController(ShortestPathService shortestPathService,
                                                          MinimumTimeService minimumTimeService,
                                                          OutputView outputView) {
        return new SubwayController(shortestPathService, minimumTimeService, outputView);
    }

    public void calculateAndPrintRoute(String selectRouteFunc, Station start, Station end) {
        Result stations = null;
        if (selectRouteFunc.equals("1")) {
            stations = shortestPathService.calculate(start, end);
        }
        if (selectRouteFunc.equals("2")) {
            stations = minimumTimeService.calculate(start, end);
        }

        printResult(stations);
    }

    private void printResult(Result result) {
        outputView.printSearchingResult(result.getTotalDistance(), result.getTotalTime());
        outputView.printRoutes(result.getRoutes());
    }
}
