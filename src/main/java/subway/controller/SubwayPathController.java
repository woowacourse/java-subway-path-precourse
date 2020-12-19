package subway.controller;

import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;

public class SubwayPathController {
    private static SubwayPathController subwayPathController;
    private String departureStation;
    private String arrivalStation;
    private GraphControllerByDistance graphControllerByDistance;
    private GraphControllerByTime graphControllerByTime;

    public SubwayPathController() {
        this.graphControllerByDistance = new GraphControllerByDistance();
        this.graphControllerByTime = new GraphControllerByTime();
    }

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
        if (!isValidArrivalStation(arrivalStation = InputView.getArrivalStation())) {
            return false;
        }
        List<String> stations = graphControllerByDistance.getMinDistance(departureStation, arrivalStation);
        double totalDistance = graphControllerByDistance.getTotalDistance(departureStation, arrivalStation);
        OutputView.printMinDistanceAndTime(stations, totalDistance);
        return true;
    }

    public Boolean printByMinTime() {
        if (!isExistStation(departureStation = InputView.getDepartureStation())) {
            return false;
        }
        if (!isValidArrivalStation(arrivalStation = InputView.getArrivalStation())) {
            return false;
        }
        List<String> stations = graphControllerByTime.getMinTime(departureStation, arrivalStation);
        double totalTime = graphControllerByTime.getTotalTime(departureStation, arrivalStation);
        OutputView.printMinTimeAndDistance(stations, totalTime);
        return true;
    }

    private boolean isValidArrivalStation(String stationName) {
        return notSameWithDeparture(stationName) && isExistStation(stationName);
    }

    private boolean notSameWithDeparture(String arrivalName) {
        boolean result = !departureStation.equals(arrivalName);
        if (!result) {
            OutputView.sameStationError();
            System.out.println();
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
