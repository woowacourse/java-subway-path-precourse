package subway.domain;

public class StationFactory {
    public static Station createStation(String name) {
        return new Station(name);
    }
}
