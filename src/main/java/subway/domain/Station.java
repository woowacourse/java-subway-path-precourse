package subway.domain;

import subway.util.PathCalculator;

public class Station {
    private String name;

    private Station(String name) {
        this.name = name;
    }

    public static Station from(String name) {
        Station station = new Station(name);
        PathCalculator.addStation(station.getName());
        StationRepository.addStation(station);
        return station;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
}
