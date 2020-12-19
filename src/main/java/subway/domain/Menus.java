package subway.domain;

import subway.controller.Navigator;
import subway.domain.exception.NonExistentMenuException;
import subway.domain.exception.NonExistentNameException;
import subway.domain.exception.SamePointsException;
import subway.view.InputView;

import java.util.Arrays;
import java.util.List;

public abstract class Menus {

    public static final Functions functions = new Functions();
    public static final Criterions criterions = new Criterions();
    private static final List<String> signs = Arrays.asList(new String[]{});

    public static void run(InputView inputView, String selectedCriterions, Navigator navigator) {
        if (isBack(selectedCriterions)) {
            return;
        }
        search(inputView, selectedCriterions, navigator);
    }

    public static void search(InputView inputView, String criterion, Navigator navigator) {
        List<String> stations = scanValidStations(inputView);
        if (criterions.isDistanceSign(criterion)) {
            navigator.searchShortestDistance(stations);
        }
        if (criterions.isTimeSign(criterion)) {
            navigator.searchShortestTime(stations);
        }
    }

    private static List<String> scanValidStations(InputView inputView) {
        String start;
        String end;
        boolean validation = false;
        do {
            start = inputView.scanStartStation();
            end = inputView.scanEndStation();
            validation = isValidStations(start, end);
        } while (!validation);
        return Arrays.asList(start, end);
    }

    private static boolean isValidStations(String start, String end) {
        try {
            checkValidationOfStations(start, end);
            return true;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private static void checkValidationOfStations(String start, String end) {
        if (Station.isSameStation(start,end)) {
            throw new SamePointsException();
        }
        if (!StationRepository.isExistStationName(start)) {
            throw new NonExistentNameException();
        }
        if (!StationRepository.isExistStationName(end)) {
            throw new NonExistentNameException();
        }
    }

    public static boolean isQuit(String sign) {
        return functions.isQuit(sign);
    }

    public static boolean isBack(String sign) {
        return criterions.isBack(sign);
    }

    public boolean isValid(String sign) {
        try {
            checkValidationOf(sign);
            return true;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    private void checkValidationOf(String sign) {
        if (!isInSignList(sign)) {
            throw new NonExistentMenuException();
        }
    }

    private boolean isInSignList(String sign) {
        if (getSigns().contains(sign)) {
            return true;
        }
        return false;
    }

    public List<String> getSigns() {
        return signs;
    }
}
