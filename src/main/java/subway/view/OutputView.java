package subway.view;

import subway.domain.PathResult;
import subway.domain.Station;

import java.util.List;

import static subway.view.resource.Constant.INFO_DIVIDER;
import static subway.view.resource.Constant.INFO_HEADER;
import static subway.view.resource.Information.*;

public class OutputView {

    public void printErrorMessage(String message) {
        print(message);
    }

    public void printInformation(String information) {
        printEmptyLine();
        print(information);
    }

    private void printEmptyLine() {
        print("");
    }

    private void print(String message) {
        System.out.println(message);
    }

    public void printPathResult(PathResult result) {
        print(PATH_INFO);
        print(INFO_HEADER + INFO_DIVIDER);
        printSummary(result);
        print(INFO_HEADER + INFO_DIVIDER);
        printFullPath(result.getStations());
    }

    private void printSummary(PathResult result) {
        print(INFO_HEADER + PATH_TOTAL_DISTANCE + result.getTotalDistance() + PATH_TOTAL_DISTANCE_KM);
        print(INFO_HEADER + PATH_TOTAL_TIME + result.getTotalTime() + PATH_TOTAL_TIME_MIN);
    }

    private void printFullPath(List<Station> stations) {
        for (Station station : stations)
            print(INFO_HEADER + station.getName());
    }
}
