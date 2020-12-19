package subway.domain;

public class Station {
    private String name;

    private Station(String name) {
        this.name = name;
    }

    public static Station newStationWithName(String name) {
        return new Station(name);
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
}
