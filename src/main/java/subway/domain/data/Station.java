package subway.domain.data;

public class Station {

    public enum POINT {
        STARTING, ENDING;
    }

    private String name;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
}
