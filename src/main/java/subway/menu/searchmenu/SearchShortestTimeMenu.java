package subway.menu.searchmenu;

import subway.domain.Interval;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.userinterface.ErrorOutput;
import subway.userinterface.InfoOutput;
import subway.userinterface.Input;

import java.util.List;

public class SearchShortestTimeMenu implements SearchMenu{
    public static final String MENU_BUTTON = "2";
    public static final String MENU_NAME = "최단 시간";


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
        try {
            Station startStation = StationRepository.findStationByName(startInput);
            Station endStation = StationRepository.findStationByName(endInput);
            List<Station> shortestPath = Interval.shortestTimePath(startStation, endStation);

            InfoOutput.printSearchResult(Interval.getTotalDistance(shortestPath), Interval.getTotalTime(shortestPath), shortestPath);
        } catch (Exception e) {
            ErrorOutput.printNotConnectedError();
        }
    }
}
