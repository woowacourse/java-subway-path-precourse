package subway;

import subway.domain.EdgeRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.domain.SubwayGraph;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Settings.init();
        Station s1 = StationRepository.getStation("교대역");
        Station s2 = StationRepository.getStation("양재시민의숲역");
        List<Station> stations = SubwayGraph.getDistanceShortestPath(s1,s2);
        for (Station station: stations) {
            System.out.println(station.getName());
        }
        System.out.println("Time" + EdgeRepository.getElapsedTime(stations));
        System.out.println("Distance" + EdgeRepository.getRouteLength(stations));
        MainService.view();
    }
}
