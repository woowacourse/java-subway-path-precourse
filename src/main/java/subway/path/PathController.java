package subway.path;

import subway.common.SelectOption;
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

    public PathController(InputView inputView) {
        this.inputView = inputView;
        this.stationService = new StationService();
    }

    public void run() {
        boolean running = true;
        while (running) {
            OutputView.showSearchPathMethod();
            List<String> optionList = getSearchOptionList();
            String method = SelectOption.askOptionChoice(inputView, optionList);
            Station startStation = getStartStation();
            Station endStation = getEndStation(startStation);

            running = searchPath(method, startStation, endStation);
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
        try {
            if (method.equals(SearchMethod.DISTANCE.getValue())) {
                searchMinimumDistance();
            }
            if (method.equals(SearchMethod.TIME.getValue())) {
                // TODO 최소 시간
            }
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    private List<String> getSearchOptionList() {
        SearchMethod[] methods = SearchMethod.values();
        List<String> optionList = new ArrayList<>();

        for (SearchMethod method : methods) {
            optionList.add(method.getValue());
        }

        return optionList;
    }

    private void searchMinimumDistance() {

    }
}
