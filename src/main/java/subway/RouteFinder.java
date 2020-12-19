package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.ArrayList;
import java.util.List;

public class RouteFinder {
    // 같은 노선 안에서 길 찾기
    public static List<Station> findRouteInSameLine(Line line, String startStation, String endStation) {
        Station start = StationRepository.getStationByName(startStation);
        Station end = StationRepository.getStationByName(endStation);
        int startPosition = line.stations().indexOf(start);
        int endPosition = line.stations().indexOf(end);
        if (startPosition > endPosition) {
            return addStartToEnd(line, endPosition, startPosition);
        }
        return addStartToEnd(line, startPosition, endPosition);
    }

    // 시작 역 부터 끝 역까지 포함하는 역을 리스트에 담는 메소드
    public static List<Station> addStartToEnd(Line line, int startPosition, int endPosition) {
        List<Station> route = new ArrayList<>();
        if (startPosition < endPosition) {
            for (int i = startPosition; i < endPosition + 1; i++) {
                route.add(line.stations().get(i));
            }
        }
        return route;
    }
}
