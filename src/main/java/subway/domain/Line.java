package subway.domain;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Line {
    private String name;
    private final Set<UnitPath> paths = new HashSet<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public void addPath(UnitPath path){
        paths.add(path);
    }

    public Optional<UnitPath> getPathOf(Station start, Station end) {
        return paths.stream()
                .filter(path -> path.isPathOf(start, end))
                .findFirst();
    }
}
