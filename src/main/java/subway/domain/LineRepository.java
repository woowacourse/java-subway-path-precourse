package subway.domain;

import java.util.*;

public class LineRepository {
    private static final Line lineTwo = new Line("2호선");
    private static final Line lineThree = new Line("3호선");
    private static final Line lineShinBunDang = new Line("신분당선");
    private static final List<Line> lines = Arrays.asList(lineTwo, lineThree, lineShinBunDang);

    public static List<Line> lines() {
        lineTwo.addStation(StationRepository.stationKyoDae);
        lineTwo.addStation(StationRepository.stationGangNam);
        lineTwo.addStation(StationRepository.stationYeokSam);
        lineThree.addStation(StationRepository.stationKyoDae);
        lineThree.addStation(StationRepository.stationNamBu);
        lineThree.addStation(StationRepository.stationYangJae);
        lineShinBunDang.addStation(StationRepository.stationGangNam);
        lineShinBunDang.addStation(StationRepository.stationYangJae);
        lineShinBunDang.addStation(StationRepository.stationYangJaeForest);
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void deleteAll() {
        lines.clear();
    }
}
