package subway.controller;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.exception.TransitRouteException;
import subway.view.InputView;
import subway.view.OutputView;

public class RouteController {

    public static void showRouteByDistance() {
        OutputView.showPrompt("출발역");
        Station departStation = StationRepository.findStationByName(InputView.getInput());
        OutputView.showPrompt("도착역");
        Station arrivalStation = StationRepository.findStationByName(InputView.getInput());
        if (departStation.equals(arrivalStation)) {
            throw new TransitRouteException("출발역과 도착역이 동일합니다.");
        }
//       출발역과 도착역이 연결되어 있나 확인
    }

    public static void showRouteByTime() {
        OutputView.showPrompt("출발역");
        Station departStation = StationRepository.findStationByName(InputView.getInput());
        OutputView.showPrompt("도착역");
        Station arrivalStation = StationRepository.findStationByName(InputView.getInput());
        if (departStation.equals(arrivalStation)) {
            throw new TransitRouteException("출발역과 도착역이 동일합니다.");
        }
    }

    /*
    비어있는 메서드, 메서드가 실행되면 이 전의 화면으로 돌아간다.
     */
    public static void back() {

    }
}
