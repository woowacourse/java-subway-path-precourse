package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayPathController {
    private static SubwayPathController subwayPathController;
    private String departureStation;
    private String arrivalStation;


    public static SubwayPathController getInstance() {
        if (subwayPathController==null) {
            subwayPathController = new SubwayPathController();
        }
        return subwayPathController;
    }

    public Boolean printByMinDistance() {
        if (!isExistStation(departureStation = InputView.getDepartureStation())) {
            return false;
        }
        if (isValidArrivalStation(arrivalStation = InputView.getArrivalStation())) {
            return false;
        }

    }

    public Boolean printByMinTime() {
        if (!isExistStation(departureStation = InputView.getDepartureStation())) {
            return false;
        }
        if (isValidArrivalStation(arrivalStation = InputView.getArrivalStation())) {
            return false;
        }

    }

    private boolean isValidArrivalStation(String s) {
        return notSameWithDeparture(s) && isExistStation(s);
    }

    private boolean notSameWithDeparture(String s) {
        boolean result = departureStation.equals(s);
        if (!result) {
            OutputView.sameStationError();
            return false;
        }
        return true;
    }

    private boolean isExistStation(String stationName){
        if (!StationRepository.searchByName(stationName)) {
            OutputView.notExistStationError();
            return false;
        }
        return true;
    }

    public Boolean back() {
        return true;
    }
}
