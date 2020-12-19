package subway.controller;

import static subway.SubwayKeyWords.*;

import java.util.TreeMap;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.exceptions.ExceptionOptionUnavailable;
import subway.exceptions.ExceptionSameStationSubmitted;
import subway.exceptions.ExceptionStationNotExists;
import subway.view.InputView;
import subway.view.OutputView;

public class RouteDashboard {

    public static String title = DASHBOARD_ROUTE;
    TreeMap<String, String> options;
    InputView inputView;
    boolean power;
    String departureStation;
    String arrivalStation;

    public RouteDashboard(InputView inputView) {
        this.inputView = inputView;
        power = true;
        options = new TreeMap<>();
        options.put(OPTION_NUM_1, DASHBOARD_ROUTE_OPTION_1);
        options.put(OPTION_NUM_2, DASHBOARD_ROUTE_OPTION_2);
        options.put(OPTION_BACK, DASHBOARD_OPTION_B);
        startRouteDashboard(inputView);
    }

    public void startRouteDashboard(InputView inputView) {
        while (power) {
            String chosenOption = makeUserChooseOption(inputView);
            startChosenOption(chosenOption);
        }
    }

    public String makeUserChooseOption(InputView inputView) {
        while (true) {
            OutputView.showOptions(title, options);
            String optionChosen = inputView.chooseOption();
            try {
                checkOptions(optionChosen);
                return optionChosen;
            } catch (ExceptionOptionUnavailable e) {
                OutputView.showErrorMessage(e);
            }
        }
    }

    public void checkOptions(String input) throws ExceptionOptionUnavailable {
        if (!options.containsKey(input)) {
            throw new ExceptionOptionUnavailable();
        }
    }

    public void startChosenOption(String option) {
        if (option.equals(OPTION_NUM_1) || option.equals(OPTION_NUM_2)) {
            try {
                submitStation(inputView);
            } catch (Exception e) {
                return;
            }
            RouteCalculator routeCalculator = new RouteCalculator(new Station(departureStation),
                new Station(arrivalStation), option);

            power = false;
        }

        if (option.equals(OPTION_BACK)) {
            power = false;
        }
    }

    public void submitStation(InputView inputView) throws Exception {
        try {
            departureStation = inputView.ChooseDepartureStation();
            StationRepository.isValidStationName(departureStation);
            arrivalStation = inputView.ChooseArrivalStation();
            StationRepository.isValidStationName(arrivalStation);
            checkNameDuplication(departureStation, arrivalStation);
        } catch (ExceptionStationNotExists e) {
            OutputView.showErrorMessage(e);
            throw new Exception();
        } catch (ExceptionSameStationSubmitted e) {
            OutputView.showErrorMessage(e);
            throw new Exception();
        }
    }

    public void checkNameDuplication(String arrivalStation, String departureStation) {
        if (arrivalStation.equals(departureStation)) {
            throw new ExceptionSameStationSubmitted();
        }
    }

}
