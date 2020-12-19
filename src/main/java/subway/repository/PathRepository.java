package subway.repository;

import subway.constant.InitialData;
import subway.domain.Path;
import subway.exception.InvalidInputException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class PathRepository {
    private static final List<Path> paths = new ArrayList<>();

    public static List<Path> paths() {
        return Collections.unmodifiableList(paths);
    }

    public static void addPath(Path path) {
        paths.add(path);
    }

    public static boolean deletePath(String srcStationName, String dstStationName) {
        return paths.removeIf(path -> Objects.equals(path.getSrcStation().getName(), srcStationName)
                && Objects.equals(path.getDstStation().getName(), dstStationName));
    }

    public static void deleteAll() {
        paths.clear();
    }

    private static void addPaths(List<Path> paths) {
        for (Path path : paths)
            addPath(path);
    }

    public static void initPaths() {
        for (List<Path> paths : InitialData.linePaths)
            addPaths(paths);
    }

    public static double getDistance(Path targetPath) throws InvalidInputException {
        for (Path path : paths)
            if (pathMatches(path, targetPath)) return path.getDistance();
        throw new InvalidInputException(InvalidInputException.ExceptionCode.NO_PATH_AVAILABLE);
    }

    private static boolean pathMatches(Path path, Path targetPath) {
        return (path.getSrcStation().equals(targetPath.getSrcStation()) && path.getDstStation().equals(targetPath.getDstStation()))
                || (path.getSrcStation().equals(targetPath.getDstStation()) && path.getDstStation().equals(targetPath.getSrcStation()));
    }

    public static double getTime(Path targetPath) throws InvalidInputException {
        for (Path path : paths)
            if (pathMatches(path, targetPath)) return path.getTime();
        throw new InvalidInputException(InvalidInputException.ExceptionCode.NO_PATH_AVAILABLE);
    }
}
