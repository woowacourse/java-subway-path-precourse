package subway.util;

import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.List;

public class CalculatorRoute {

    public static int calculatorRoutDistance(List<String> stationList) {
        int result = 0;
        String tempStataion = stationList.get(0);
        for (int i = 1; i < stationList.size(); i++) {
            Station station = StationRepository.findStationByName(tempStataion);
            result += station.getSectionDistance(stationList.get(i));
            tempStataion = stationList.get(i);
        }
        return result;
    }

    public static int calculatorRouteTime(List<String> stationList) {
        int result = 0;
        String tempStataion = stationList.get(0);
        for (int i = 1; i < stationList.size(); i++) {
            Station station = StationRepository.findStationByName(tempStataion);
            result += station.getSectionTime(stationList.get(i));
            tempStataion = stationList.get(i);
        }
        return result;
    }
}
