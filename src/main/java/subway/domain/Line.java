package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private String name;
    private List<Station> stations = new ArrayList<Station>();
    private List<Integer> distances = new ArrayList<Integer>(); // 0번째와 1번째 station들의 관계는 0번째 인덱스에 존재한다.
    private List<Integer> times = new ArrayList<Integer>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void pushSections(Station station, int distance, int time) {
        stations.add(station);
        distances.add(distance);
        times.add(time);
    }
}
