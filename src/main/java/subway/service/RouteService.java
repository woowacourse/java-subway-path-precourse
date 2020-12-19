package subway.service;

import java.util.Arrays;
import java.util.List;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Route;
import subway.domain.RouteRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class RouteService {
    private static final List<String[]> routeInformations = Arrays
        .asList(new String[]{"교대역", "강남역", "2호선", "2", "3"},
            new String[]{"강남역", "역삼역", "2호선", "2", "3"},
            new String[]{"교대역", "남부터미널역", "3호선", "3", "2"},
            new String[]{"남부터미널역", "양재역", "3호선", "6", "5"},
            new String[]{"양재역", "매봉역", "3호선", "1", "1"},
            new String[]{"강남역", "양재역", "신분당선", "2", "8"},
            new String[]{"양재역", "양재시민의숲역", "신분당선", "10", "3"}
            );

    public RouteService(){
        initialize();
    }

    public static void initialize(){
        for(String[] routeInformation: routeInformations){
            Station currentStation = StationRepository.getStationByName(routeInformation[0]);
            Station nextStation = StationRepository.getStationByName(routeInformation[1]);
            Line line = LineRepository.getLineByName(routeInformation[2]);
            if(currentStation.equals(null)||nextStation.equals(null)||line.equals(null))
                continue;
            int distance = Integer.parseInt(routeInformation[3]);
            int time = Integer.parseInt(routeInformation[4]);
            Route route = new Route(currentStation,nextStation,line,distance,time);
            RouteRepository.addRoute(route);
        }
    }
}