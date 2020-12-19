package subway.service;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.OutputView;
import subway.view.inputview.PathView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PathService {
    private static final Scanner scanner = new Scanner(System.in);
    private static final int NONE = 0;
    private static final String ERROR_SAME_STATION = "[ERROR] 출발역과 도착역이 동일합니다.";
    private static final String ERROR_NO_CONNECTION = "[ERROR] 출발역과 도착역이 연결되어있지 않습니다.";

    private PathService() {
    }

    public static boolean findShortestDistancePath() {
        try {
            List<Line> lines = new ArrayList<>();
            Station start = getDefartureStation();
            Station end = getArrivalStation();
            validateSameStation(start, end);
            lines = HasTwoStationsInLines(start, end);
            Line shortestPathLine = findShortestPathLine(lines, start, end);
            OutputView.printResult((int) shortestPathLine.getTotalDistance(start, end), (int) shortestPathLine.getTotalTime(start, end), shortestPathLine.getShortestDistancePath(start, end));
            return true;
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return false;
        }
    }

    public static boolean findMinimumTimePath() {
        try {
            List<Line> lines = new ArrayList<>();
            Station start = getDefartureStation();
            Station end = getArrivalStation();
            validateSameStation(start, end);
            lines = HasTwoStationsInLines(start, end);
            Line minimumTimeLine = findMinimumTimeLine(lines, start, end);
            OutputView.printResult((int) minimumTimeLine.getTotalDistance(start, end), (int) minimumTimeLine.getTotalTime(start, end), minimumTimeLine.getShortestDistancePath(start, end));
            return true;
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return false;
        }
    }

    private static Line findShortestPathLine(List<Line> lines, Station start, Station end) {
        List<String> shortestPath = new ArrayList<>();
        Line shortestPathLine = null;
        for (Line line : lines) {
            List<String> newPath = line.getShortestDistancePath(start, end);

            if (shortestPath.size() == NONE || newPath.size() < shortestPath.size()) {
                shortestPath = newPath;
                shortestPathLine = line;
            }

        }

        return shortestPathLine;
    }

    private static Line findMinimumTimeLine(List<Line> lines, Station start, Station end) {
        List<String> minimumPath = new ArrayList<>();
        Line minimumPathLine = null;
        for (Line line : lines) {
            List<String> newPath = line.getMinimumTimePath(start, end);

            if (minimumPath.size() == NONE || newPath.size() < minimumPath.size()) {
                minimumPath = newPath;
                minimumPathLine = line;
            }

        }

        return minimumPathLine;
    }

    private static List<Line> HasTwoStationsInLines(Station start, Station end) {
        List<Line> linesWithTwoStations = new ArrayList<>();
        linesWithTwoStations = findLinesWithTwoStations(start, end);

        if (linesWithTwoStations.size() == NONE) {
            throw new IllegalArgumentException(ERROR_NO_CONNECTION);
        }

        return linesWithTwoStations;
    }

    private static List<Line> findLinesWithTwoStations(Station start, Station end) {
        List<Line> lines = new ArrayList<>();

        for (Line line : LineRepository.lines()) {
            if (line.hasTwoStations(start, end)) {
                lines.add(line);
            }
        }

        return lines;
    }

    private static Station getDefartureStation() {
        String stationName = PathView.getInstance(scanner).inputDepartureStation();
        return StationRepository.findStationByName(stationName);
    }

    private static Station getArrivalStation() {
        String stationName = PathView.getInstance(scanner).inputArrivalStation();
        return StationRepository.findStationByName(stationName);
    }

    private static void validateSameStation(Station start, Station end) {
        if (start.getName().equals(end.getName())) {
            throw new IllegalArgumentException(ERROR_SAME_STATION);
        }
    }
}
