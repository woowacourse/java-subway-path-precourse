package subway.enums.initializer;

import subway.domain.Route;
import subway.domain.RouteRepository;

import java.util.Arrays;
import java.util.List;

public enum InitialRoutes {
    ROUTE_2(InitialLines.LINE_2
            ,Arrays.asList(InitialStations.KYODAE, InitialStations.GANGNAM, InitialStations.YEOKSAM)
            , TimeToStation.LINE_2
            , DistanceToStation.LINE_2
    ),

    ROUTE_3(InitialLines.LINE_3
            ,Arrays.asList(InitialStations.KYODAE, InitialStations.NAMBU_TERMINAL, InitialStations.YANGJAE, InitialStations.MAEBONG)
            ,TimeToStation.LINE_3
            ,DistanceToStation.LINE_3
    ),

    ROUTE_SINBUNDANG(InitialLines.LINE_SINBUNDANG
            ,Arrays.asList(InitialStations.GANGNAM, InitialStations.YANGJAE, InitialStations.YANGJAE_SIMIN_SOUP)
            ,TimeToStation.LINE_SINBUNDANG
            ,DistanceToStation.LINE_SINBUNDANG
    );

    private InitialLines line;
    private List<InitialStations> stations;
    private TimeToStation timeToNextStation;
    private DistanceToStation distanceToNextStation;

    InitialRoutes(InitialLines line, List<InitialStations> stations, TimeToStation timeToNextStation
            , DistanceToStation distanceToNextStation) {
        this.line = line;
        this.stations = stations;
        this.timeToNextStation = timeToNextStation;
        this.distanceToNextStation = distanceToNextStation;
    }

    public InitialLines getLine() {
        return line;
    }

    public List<InitialStations> getStations() {
        return stations;
    }

    public TimeToStation getTimeToNextStation() {
        return timeToNextStation;
    }

    public DistanceToStation getDistanceToNextStation() {
        return distanceToNextStation;
    }

    public static void initializeRoutes() {
        Arrays.stream(InitialRoutes.values())
                .map(Route::new)
                .forEach(RouteRepository::addRoute);
    }
}

