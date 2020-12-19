package subway.validator;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.exception.UserInputException;
import subway.view.ErrorView;
import subway.view.routefindoutput.RouteFindErrorView;

import java.util.List;

public class RouteFindValidation extends Validation {
    private static final int NO_STATIONS_IN_THE_PATH = 0;

    public static boolean checkControllerInput(String userInput) {
        try {
            if (!((userInput.equals(OPTION_ONE)) || (userInput.equals(OPTION_TWO)) || (userInput.equals(OPTION_BACK)))) {
                throw new UserInputException();
            }
        } catch (UserInputException e) {
            ErrorView.printOptionError();
            return false;
        }
        return true;
    }

    public static boolean checkValidStartStation(String userInputStartStation) {
        if(!checkIsInStationRepository(userInputStartStation)) {
            return false;
        }
        return true;
    }

    public static boolean checkValidEndStation(String userInputStartStation, String userInputEndStation) {
        if(!checkIsInStationRepository(userInputEndStation)) {
            return false;
        }
        if(checkSameStation(userInputStartStation, userInputEndStation)) {
            return false;
        }
        return true;
    }

    private static boolean checkIsInStationRepository(String userInputStation) {
        try {
            if (StationRepository.getStationByName(userInputStation) == null) {
                throw new UserInputException();
            }
        } catch (UserInputException e) {
            RouteFindErrorView.printNotInStationRepositoryError();
            return false;
        }
        return true;
    }

    private static boolean checkSameStation(String userInputStartStation, String userInputEndStation) {
        try {
            if (userInputStartStation.equals(userInputEndStation)) {
                throw new UserInputException();
            }
        } catch (UserInputException e) {
            RouteFindErrorView.printSameStationInputError();
            return true;
        }
        return false;
    }

    public static boolean checkValidPath(List<Station> shortestPath) {
        try {
            if (shortestPath.size() == NO_STATIONS_IN_THE_PATH) {
                throw new UserInputException();
            }
        } catch (UserInputException e) {
            RouteFindErrorView.printPathNotConnectedError();
            return false;
        }
        return true;
    }
}
