package subway.repository;

import subway.constant.InitialData;
import subway.domain.Path;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PathRepository {
    private static final List<Path> paths = new ArrayList<>();

    public static List<Path> paths() {
        return Collections.unmodifiableList(paths);
    }

    public static void addPath(Path path) {
        paths.add(path);
    }

    private static void addPaths(List<Path> paths) {
        for (Path path : paths)
            addPath(path);
    }

    public static void initPaths() {
        for (List<Path> paths : InitialData.linePaths)
            addPaths(paths);
    }

    public static double getDistance(Path targetPath) {
        for (Path path : paths)
            if (pathMatches(path, targetPath)) return path.getDistance();
        return 0;   // TODO: 예외처리
    }

    private static boolean pathMatches(Path path, Path targetPath) {
        return (path.getSrcStation().equals(targetPath.getSrcStation()) && path.getDstStation().equals(targetPath.getDstStation()))
                || (path.getSrcStation().equals(targetPath.getDstStation()) && path.getDstStation().equals(targetPath.getSrcStation()));
    }

    public static double getTime(Path targetPath) {
        for (Path path : paths)
            if (pathMatches(path, targetPath)) return path.getTime();
        return 0;   // TODO: 예외처리
    }
}
