package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private String name;
    private List<Station> stations = new ArrayList<>();

    private Line(String name) {
        this.name = name;
    }

    public static Line create(String name){
        return new Line(name);
    }

    public void addStationsInLine(final Station station){
        stations.add(station);
    }

    public String getName() {
        return name;
    }

    public boolean isEqualName(String name){
        return name.equals(this.name);
    }

    // 추가 기능 구현
}
