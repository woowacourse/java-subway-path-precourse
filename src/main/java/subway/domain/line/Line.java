package subway.domain.line;

import subway.domain.path.Path;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Path> paths = new ArrayList<>();
    private String name;

    public Line(String name) {
        this.name = name;
    }

    public void addPath(Path path) {
        paths.add(path);
    }

    public String getName() {
        return name;
    }
}
