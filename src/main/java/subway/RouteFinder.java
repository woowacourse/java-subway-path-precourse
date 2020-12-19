package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.ArrayList;
import java.util.List;

public class RouteFinder {
    // 같은 노선 안에서 길 찾기
    public static List<Station> findRouteInSameLine(String startStation, String endStation) {
        Station start = StationRepository.getStationByName(startStation);
        Station end = StationRepository.getStationByName(endStation);
        Line line = LineRepository.getLineByStation(start);
        List<Station> route = new ArrayList<>();
        int startPosition = line.stations().indexOf(start);
        int endPosition = line.stations().indexOf(end);
        for (int i = startPosition; i < endPosition + 1; i++) {
            route.add(line.stations().get(i));
        }
        return route;
    }
}
