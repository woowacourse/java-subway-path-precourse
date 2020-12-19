package subway.service;

import subway.service.dto.DistanceAndTimeDto;

import java.util.List;

import static subway.util.PathCalculator.calculateShortestDistancePath;
import static subway.view.InputView.inputEndStation;
import static subway.view.InputView.inputStartStation;
import static subway.view.OutputView.printPathResult;

public class DistancePathService extends BaseService{

    public static void serviceStart() {
        List<String> passByStations = getPassByStations();
        DistanceAndTimeDto distanceAndTimeDto = getTotalTimeAndDistance(passByStations);
        printPathResult(passByStations, distanceAndTimeDto.getDistance(), distanceAndTimeDto.getTime());
    }

    private static List<String> getPassByStations() {
        String startStationName = inputStartStation();
        String endStationName = inputEndStation(startStationName);
        return calculateShortestDistancePath(startStationName, endStationName);
    }

    private static DistanceAndTimeDto getTotalTimeAndDistance(List<String> passByStations) {
        return calculateTotalTimeAndDistance(passByStations);
    }
}
