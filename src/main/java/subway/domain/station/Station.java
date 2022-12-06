package subway.domain.station;

public class Station {
    private String name;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public boolean nameEquals(String input) {
        return name.equals(input);
    }

}
