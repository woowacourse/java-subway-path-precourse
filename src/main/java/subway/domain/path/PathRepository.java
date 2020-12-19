package subway.domain.path;

import subway.domain.station.Station;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PathRepository {
    private static List<Path> paths = new ArrayList<>();

    public static void addPath(Path path) {
        paths.add(path);
    }

    public static List<Path> findBySource(Station source) {
        return paths.stream()
                .filter(path -> path.getSource().equals(source))
                .collect(Collectors.toList());
    }
}
