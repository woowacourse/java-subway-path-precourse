package subway.service;

import subway.service.dto.DistanceAndTimeDto;

import java.util.List;

import static subway.util.PathCalculator.calculateShortestTimePath;
import static subway.view.InputView.inputEndStation;
import static subway.view.InputView.inputStartStation;
import static subway.view.OutputView.printPathResult;

public class TimePathService extends BaseService{

    public static void serviceStart() {
        String startStationName = inputStartStation();
        String endStationName = inputEndStation(startStationName);
        List<String> passByStations = calculateShortestTimePath(startStationName, endStationName);
        DistanceAndTimeDto distanceAndTimeDto = calculateTotalTimeAndDistance(passByStations);
        printPathResult(passByStations, distanceAndTimeDto.getDistance(), distanceAndTimeDto.getTime());
    }
}
