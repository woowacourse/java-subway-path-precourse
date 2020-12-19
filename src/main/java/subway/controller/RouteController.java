package subway.controller;

import java.util.ArrayList;
import java.util.List;

import subway.domain.Section;
import subway.domain.SectionRepository;
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
            findMinDistanceRoute();
        }
        if (isEqual(selection, FINDING_MIN_TIME)) {
            findMinTimeRoute();
        }
    }

    private boolean isEqual(String selection, String menu) {
        return selection.equals(menu);
    }

    private void findMinDistanceRoute() {
        try {
            String startStation = receiveAndValidateStartStation();
            String endStation = receiveAndValidateEndStation();
            validateRelationshipBetween(startStation, endStation);
            OutputView.printResult(findDistanceRoutes(startStation, endStation));
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            goToRouteMenu();
        }
    }

    private List<String> findDistanceRoutes(String startStation, String endStation) {
        RouteDistanceController routeDistanceController = new RouteDistanceController();
        List<String> routes = routeDistanceController.findMinDistance(startStation, endStation);
        List<Section> sections = SectionRepository.sections();
        List<String> results = new ArrayList<>();
        int routeSize = routes.size();
        int sumDistance = 0;
        int sumTime = 0;
        for (int i = 0; i < routeSize - 1; i++) {
            for (Section section : sections) {
                if (section.isSectionBetween(routes.get(i), routes.get(i + 1))) {
                    sumDistance += section.getDistance();
                    sumTime += section.getTime();
                }
            }
        }
        results.add("---");
        results.add("총 거리: " + sumDistance + "km");
        results.add("총 소요 시간: " + sumTime + "분");
        results.add("---");
        results.addAll(routes);
        return results;
    }

    private void findMinTimeRoute() {
        try {
            String startStation = receiveAndValidateStartStation();
            String endStation = receiveAndValidateEndStation();
            validateRelationshipBetween(startStation, endStation);
            // 최단 시간 경로 찾는 로직 미구현 (최단 거리 경로 찾는 로직과 동일하나, 리팩토링이 안돼서 넣지 않음)
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            goToRouteMenu();
        }
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
