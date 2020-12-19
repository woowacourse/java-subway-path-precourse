package subway.controller;

import subway.view.InputView;
import subway.view.OutputView;

public class RouteController {
    private static final String ROUTE_MENU = "Route";
    private static final String FINDING_MIN_DISTANCE = "1";
    private static final String FINDING_MIN_TIME = "2";

    private InputView inputView;
    private RouteValidator routeValidator;

    public RouteController(InputView inputView) {
        this.inputView = inputView;
        this.routeValidator = new RouteValidator();
    }

    public void goToRouteMenu() {
        OutputView.printRouteMenu();
        String selection = inputView.receiveMenuSelection(ROUTE_MENU);
        goToFindMenuBySelection(selection);
    }

    private void goToFindMenuBySelection(String selection) {
        if (isEqual(selection, FINDING_MIN_DISTANCE)) {
            findMinDistance();
        }
        if (isEqual(selection, FINDING_MIN_TIME)) {
            findMinTime();
        }
    }

    private boolean isEqual(String selection, String menu) {
        return selection.equals(menu);
    }

    private void findMinDistance() {
        try {
            String startStation = receiveAndValidateStartStation();
            String endStation = receiveAndValidateEndStation();
            validateRelationshipBetween(startStation, endStation);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            goToRouteMenu();
        }
    }

    private void findMinTime() {
        // 구현 추가 예정
    }

    private String receiveAndValidateStartStation() {
        String startStation = inputView.receiveStartStationName();
        routeValidator.validateStationName(startStation);
        routeValidator.validateStationIsExisted(startStation);
        return startStation;
    }

    private String receiveAndValidateEndStation() {
        String endStation = inputView.receiveEndStationName();
        routeValidator.validateStationName(endStation);
        routeValidator.validateStationIsExisted(endStation);
        return endStation;
    }

    private void validateRelationshipBetween(String startStation, String endStation) {
        routeValidator.validateStartEqualsEnd(startStation, endStation);
        routeValidator.validateStartIsNotConnectedWithEnd(startStation, endStation);
    }
}
