package subway.domain;

import subway.Exception.CanNotConnectStationException;

import java.util.ArrayList;
import java.util.List;

public class LineStationRepository {
    private static final String NEW_LINE = "\n";
    private static final String PRINT_INFO = "[INFO] ";
    private static final String SEPARATOR = "[INFO] --- \n";

    private static final List<LineStation> subwayMap = new ArrayList<>();

    public static void addLineStation(LineStation lineStation) {
        subwayMap.add(lineStation);
    }

    public static List<LineStation> findLineWithStation(Station startStation, Station arriveStation) {
        List<LineStation> findLineStation = new ArrayList<>();
        for (LineStation lineStation : subwayMap) {
            List<Station> checkStations = lineStation.getStations();
            if (checkStations.contains(startStation) && checkStations.contains(arriveStation)){
                findLineStation.add(lineStation);
            }
        }
        if (findLineStation.isEmpty()) {
            throw new CanNotConnectStationException();
        }
        return findLineStation;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (LineStation lineStation : subwayMap) {
            sb.append(PRINT_INFO + lineStation.getLine().getName() + NEW_LINE);
            sb.append(SEPARATOR);
            for (Station station : lineStation.getStations()) {
                sb.append(PRINT_INFO + station.getName() + NEW_LINE);
            }
            for (Section sectionInfo : lineStation.getSectionInfos()) {
                sb.append(PRINT_INFO + sectionInfo + NEW_LINE);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
