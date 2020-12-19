package subway.domain.station;

import java.util.ArrayList;
import java.util.List;

public class Station {
    private String name;
    private List<Path> paths = new ArrayList<>();

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPath(Path path) {
        paths.add(path);
    }
}
