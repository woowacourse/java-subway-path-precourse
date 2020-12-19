package subway.repository;

import subway.domain.SubwayPath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubwayPathRepository {
    private static final List<SubwayPath> SUBWAY_PATHS = new ArrayList<>();

    public static List<SubwayPath> paths() {
        return Collections.unmodifiableList(SUBWAY_PATHS);
    }

    public static void addPath(SubwayPath subwayPath) {
        SUBWAY_PATHS.add(subwayPath);
    }
}
