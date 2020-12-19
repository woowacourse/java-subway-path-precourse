package subway.enums;

import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.Arrays;

public enum Stations {
    KYODAE("교대역"),
    GANGNAM("강남역"),
    YEOKSAM("역삼역"),
    NAMBU_TERMINAL("남부터미널역"),
    YANGJAE("양재역"),
    YANGJAE_SIMIN_SOUP("양재시민의숲역"),
    MAEBONG("매봉역");

    private String name;

    Stations(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void initializeStations() {
        Arrays.stream(Stations.values())
                .map(Stations::getName)
                .map(Station::new)
                .forEach(StationRepository::addStation);
    }
}
