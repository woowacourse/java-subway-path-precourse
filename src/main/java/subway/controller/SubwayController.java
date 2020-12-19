package subway.controller;

import subway.domain.*;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.stream.Collectors;

import static subway.domain.InitSetting.initSetting;

public class SubwayController {
    public void run(InputView inputView) {
        initSetting();
        while (true) {
            OutputView.printMain();
            if (isValidMainAction(inputView)) {
                break;
            }
            doAction(inputView);
        }
    }

    private boolean isValidMainAction(InputView inputView) {
        try {
            return MainAction.isFinish(inputView.receiveAction());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return isValidMainAction(inputView);
        }
    }

    private void doAction(InputView inputView) {
        while (true) {
            OutputView.printPathAction();
            PathAction pathAction = makePathAction(inputView);
            if (pathAction.equals(PathAction.BACK)) {
                break;
            }
            makeResult(inputView, pathAction);
        }
    }

    private PathAction makePathAction(InputView inputView) {
        try {
            return PathAction.makePathAction(inputView.receiveAction());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return makePathAction(inputView);
        }
    }

    private void makeResult(InputView inputView, PathAction pathAction) {
        try {
            Station startStation = StationRepository.findStationByName(inputView.receiveStart());
            Station finishStation = StationRepository.findStationByName(inputView.receiveFinish());

            checkValidStations(startStation, finishStation);

            pathAction.doAction(startStation, finishStation);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            makeResult(inputView, pathAction);
        }
    }

    private static void checkValidStations(Station startStation, Station finishStation) {
        if (startStation.equals(finishStation)) {
            throw new IllegalArgumentException("출발역과 도착역이 같을 수 없습니다.");
        }
    }

    public static void makeShortestTime(Station startStation, Station finishStation) {
        ShortestTimeReport shortestTimeReport = new ShortestTimeReport(SubwayTimeRepository.subwayTime());
        shortestTimeReport.makePaths(startStation, finishStation);

        int totalTime = shortestTimeReport.calculateTotalTime();
        int totalLength = shortestTimeReport.calculateTotalLength();

        OutputView.printReport(totalLength, totalTime);
        OutputView.printStations(shortestTimeReport.makeStations().stream().map(Station::toString).collect(Collectors.toList()));
    }

    public static void makeShortestLength(Station startStation, Station finishStation) {
        ShortestLengthReport shortestLengthReport = new ShortestLengthReport(SubwayLengthRepository.subwayLength());
        shortestLengthReport.makePaths(startStation, finishStation);

        int totalTime = shortestLengthReport.calculateTotalTime();
        int totalLength = shortestLengthReport.calculateTotalLength();

        OutputView.printReport(totalLength, totalTime);
        OutputView.printStations(shortestLengthReport.makeStations().stream().map(Station::toString).collect(Collectors.toList()));
    }
}
