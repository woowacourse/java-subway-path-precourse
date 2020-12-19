package subway.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Path;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import utils.LineUtils;

public class PathService {
    private static List<Path> arrivalPath = new ArrayList<Path>();

    private PathService() {
    }

    public static Path shortestDistancePath(Scanner scanner) {
        try {
            String stationName = InputView.inputStationName(scanner, LineUtils.ASK_DEPARTURE);
            Station departure = getStation(stationName);
            stationName = InputView.inputStationName(scanner, LineUtils.ASK_ARRIVAL);
            Station arrival = getStation(stationName);
            validateDifference(departure, arrival);
            arrivalPath.clear();
            calculatePath(new Path(departure, 0, 0), arrival, 1);
            calculatePath(new Path(departure, 0, 0), arrival, -1);
            return arrivalPath.stream().min(Comparator.comparing(path -> path.getDistance())).get();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        } catch (NoSuchElementException e) {
            System.out.println(LineUtils.ERROR_NOT_CONNECT);
            return null;
        }
    }

    private static void calculatePath(Path path, Station arrival, int upDown) {
        List<Line> linesContainDeparture = LineRepository.findLinesContainStation(path.getStation());
        for (Line line: linesContainDeparture) {
            Path nextPath = getNext(line, path, upDown);
            if (nextPath == null) {
                continue;
            }
            if (nextPath.getStation().equals(arrival)) {
                arrivalPath.add(nextPath);
                continue;
            }
            calculatePath(nextPath, arrival, upDown);
        }
    }

    private static Path getNext(Line line, Path path, int upDown) {
        Station station = line.nextStation(path.getStation(), upDown);
        if (station == null) {
            return null;
        }
        path.addStation(station);
        path.addDistance(line.totalDistance(path.getStation(), upDown));
        path.addTime(line.takingTime(path.getStation(), upDown));
        return path;
    }

    private static void validateDifference(Station departure, Station arrival) {
        if (departure.equals(arrival)) {
            throw new IllegalArgumentException(LineUtils.ERROR_BAD_ARRIVAL);
        }
    }

    private static Station getStation(String stationName) {
        try{
            return StationRepository.findStation(stationName);
        } catch (Exception e) {
            throw new IllegalArgumentException(LineUtils.ERROR_NOT_EXIST);
        }
    }

    public static void shortestTimePath() {
    }
}
