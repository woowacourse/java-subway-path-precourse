package subway.domain.repository;

import java.util.HashSet;
import java.util.List;
import subway.domain.Station;
import subway.domain.UnitPath;

public class PathRepository {
    private static HashSet<UnitPath> paths = new HashSet<>();

    public static void addPath(UnitPath path){
        paths.add(path);
    }

    public static int getTotalTime(List<Station> totalPath){
        int time = 0;
        for (int i = 0; i < totalPath.size() - 2; i++) {
            int finalI = i;
            UnitPath unitPath =
                    paths.stream()
                    .filter(path -> path.isPathOf(totalPath.get(finalI), totalPath.get(finalI + 1)))
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
            time += unitPath.getTime();
        }
        return time;
    }

    public static int getTotalDistance(List<Station> totalPath){
        int distance = 0;
        for (int i = 0; i < totalPath.size() - 2; i++) {
            int finalI = i;
            UnitPath unitPath = paths.stream()
                    .filter(path -> path.isPathOf(totalPath.get(finalI), totalPath.get(finalI + 1)))
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
            distance += unitPath.getDistance();
        }
        return distance;
    }
}
