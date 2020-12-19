package subway.path;

import org.jgrapht.GraphPath;
import subway.common.SelectOption;
import subway.line.Line;
import subway.line.LineService;
import subway.path.validation.ConnectStation;
import subway.station.Station;
import subway.station.StationService;
import subway.station.validation.NotRegisterStation;
import subway.station.validation.SameStartEndStation;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class PathController {
    private InputView inputView;
    private StationService stationService;
    private PathService pathService;
    private LineService lineService;

    public PathController(InputView inputView) {
        this.inputView = inputView;
        this.stationService = new StationService();
        this.pathService = new PathService();
        this.lineService = new LineService();
    }

    public void run() {
        boolean running = true;
        while (running) {
            try {
                OutputView.showSearchPathMethod();
                List<String> optionList = getSearchOptionList();
                String method = SelectOption.askOptionChoice(inputView, optionList);

                if (method.equals(SearchMethod.BACK.getValue())) {
                    break;
                }

                Station startStation = getStartStation();
                Station endStation = getEndStation(startStation);
                running = searchPath(method, startStation, endStation);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Station getStartStation() {
        OutputView.askStartStationName();
        return getStation();
    }

    private Station getEndStation(Station startStation) {
        OutputView.askEndStationName();
        Station endStation = getStation();
        SameStartEndStation.validate(startStation, endStation);
        return endStation;
    }

    private Station getStation() {
        String stationName = inputView.stationName();
        Station station = stationService.findStation(stationName);
        NotRegisterStation.validate(station);
        return station;
    }

    private boolean searchPath(String method, Station startStation, Station endStation) {
        if (method.equals(SearchMethod.DISTANCE.getValue())) {
            searchMinimumDistance(startStation, endStation);
        }
        if (method.equals(SearchMethod.TIME.getValue())) {
            searchMinimumTime(startStation, endStation);
        }
        return false;
    }

    private List<String> getSearchOptionList() {
        SearchMethod[] methods = SearchMethod.values();
        List<String> optionList = new ArrayList<>();

        for (SearchMethod method : methods) {
            optionList.add(method.getValue());
        }

        return optionList;
    }

    private void searchMinimumDistance(Station startStation, Station endStation) {
        List<Station> stations = stationService.findAllStation();
        List<Line> lines = lineService.findAllLine();

        GraphPath path = pathService.getDijkstraShortestPath(stations, lines, startStation, endStation, SearchMethod.DISTANCE.getValue());
        ConnectStation.validate(path);

        List<Station> shortestPath = pathService.getMinimumPath(path);
        int shortestDistance = Integer.parseInt(String.valueOf(Math.round(pathService.getMinimumWeight(path))));
        int shortestTime = pathService.getPathTime(shortestPath);

        OutputView.showMinimumCostPath(shortestPath, shortestDistance, shortestTime);
    }

    private void searchMinimumTime(Station startStation, Station endStation) {
        List<Station> stations = stationService.findAllStation();
        List<Line> lines = lineService.findAllLine();

        GraphPath path = pathService.getDijkstraShortestPath(stations, lines, startStation, endStation, SearchMethod.TIME.getValue());
        ConnectStation.validate(path);

        List<Station> shortestPath = pathService.getMinimumPath(path);
        int shortestDistance = pathService.getPathDistance(shortestPath);
        int shortestTime = Integer.parseInt(String.valueOf(Math.round(pathService.getMinimumWeight(path))));

        OutputView.showMinimumCostPath(shortestPath, shortestDistance, shortestTime);
    }
}
