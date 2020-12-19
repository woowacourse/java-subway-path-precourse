package subway.domain;

public class Station {
    private String name;
    private int distance;
    private int time;

    public Station(String name) {
        this.name = name;
    }

    public Station(String name, int distance, int time) {
        this.name = name;
        this.distance = distance;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public int getTime() {
        return this.time;
    }

    public int getDistance() {
        return this.distance;
    }
}
