package subway.menu.searchmenu;

import subway.domain.Interval;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.userinterface.ErrorOutput;
import subway.userinterface.InfoOutput;
import subway.userinterface.Input;

import java.util.List;

public class SearchShortestDistanceMenu implements SearchMenu {
    public static final String MENU_BUTTON = "1";
    public static final String MENU_NAME = "최단 거리";

    @Override
    public void run() {
        checkStationInput();
    }

    private void checkStationInput() {
        Input.printStartStation();
        String startInput = Input.newInput();
        if (ErrorOutput.printWrongStationInput(startInput)) {
            return;
        }

        Input.printEndStation();
        String endInput = Input.newInput();
        if (ErrorOutput.printWrongStationInput(endInput) || ErrorOutput.printSameStationNameError(startInput, endInput)) {
            return;
        }

        searchPath(startInput, endInput);
    }

    private void searchPath(String startInput, String endInput) {
        Station startStation = StationRepository.findStationByName(startInput);
        Station endStation = StationRepository.findStationByName(endInput);
        List<Station> shortestList = Interval.shortestDistancePath(startStation, endStation);

        InfoOutput.printSearchResult(Interval.getTotalDistance(shortestList), Interval.getTotalTime(shortestList), shortestList);
    }
}
