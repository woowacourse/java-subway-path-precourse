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
            if (MainAction.isFinish(inputView.receiveAction())) {
                break;
            }
            makeAction(inputView);
        }
    }

    private void makeAction(InputView inputView) {
        while (true) {
            OutputView.printPathAction();
            if (PathAction.isBack(inputView.receiveAction())) {
                break;
            }

            Station startStation = StationRepository.findStationByName(inputView.receiveStart());
            Station finishStation = StationRepository.findStationByName(inputView.receiveFinish());

            checkValidStations(startStation, finishStation);

            makeShortestTime(startStation, finishStation);
            makeShortestLength(startStation, finishStation);
        }
    }

    public static void checkValidStations(Station startStation, Station finishStation){
        if(startStation.equals(finishStation)){
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

    private void makeShortestLength(Station startStation, Station finishStation) {
        ShortestLengthReport shortestLengthReport = new ShortestLengthReport(SubwayLengthRepository.subwayLength());
        shortestLengthReport.makePaths(startStation, finishStation);

        int totalTime = shortestLengthReport.calculateTotalTime();
        int totalLength = shortestLengthReport.calculateTotalLength();

        OutputView.printReport(totalLength, totalTime);
        OutputView.printStations(shortestLengthReport.makeStations().stream().map(Station::toString).collect(Collectors.toList()));
    }
}
