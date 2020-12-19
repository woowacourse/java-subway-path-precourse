package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private String name;
    private List<Path> paths = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Path> getPaths() {
        return paths;
    }

    public void addPaths(List<Path> paths) {
        this.paths = paths;
    }
}
