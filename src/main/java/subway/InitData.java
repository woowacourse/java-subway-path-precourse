package subway;

import subway.domain.data.Line;
import subway.domain.data.LineRepository;
import subway.domain.data.Station;
import subway.domain.data.StationRepository;

import java.util.ArrayList;
import java.util.List;

public class InitData {
    private static String[] stations = {"교대역", "강남역", "역삼역"
            , "남부터미널역", "양재역", "양재시민의숲역", "매봉역"};

    private static String[] line2 = {"교대역", "강남역", "역삼역"};
    private static int[] line2Distance = {2, 2};
    private static int[] line2Time = {3, 3};
    private static String[] line3 = {"교대역", "남부터미널역", "양재역", "매봉역"};
    private static int[] line3Distance = {3, 6, 1};
    private static int[] line3Time = {2, 5, 1};
    private static String[] lineSinbundang = {"강남역", "양재역", "양재시민의숲역"};
    private static int[] lineSinbundangDistance = {2, 10};
    private static int[] lineSinbundangTime = {8, 3};

    public static void initData() {
        initStation();
        initLine();
    }

    private static void initLine() {
        List<Line> lineList = setInitLines();

        for(Line line : lineList) {
            LineRepository.addLine(line);
        }
    }

    private static List<Line> setInitLines() {
        List<Line> lineList = new ArrayList<>();
        String[] lineNames = {"2호선", "3호선", "신분당선"};

        for (String lineName : lineNames) {
            Line line = new Line(lineName);
            line.addStationListInLine(getStationsInLine(lineName));
            line.addStationPathDistanceListInLine(getPathDistanceInLine(lineName));
            line.addStationPathTimeListInLine(getPathTimeInLine(lineName));
            lineList.add(line);
        }

        return lineList;
    }

    private static List<Integer> getPathDistanceInLine(String lineName) {
        int[] distances = initDistanceInLine(lineName);
        List<Integer> distanceList = new ArrayList<>();

        for (int distance : distances) {
            distanceList.add(distance);
        }

        return distanceList;
    }
    private static List<Integer> getPathTimeInLine(String lineName) {
        int[] times = initTimeInLine(lineName);
        List<Integer> timeList = new ArrayList<>();

        for (int time : times) {
            timeList.add(time);
        }

        return timeList;
    }

    private static List<Station> getStationsInLine(String lineName) {
        String[] lineNameList = initLineNames(lineName);
        List<Station> stationList = new ArrayList<>();

        for (String name : lineNameList) {
            stationList.add(new Station(name));
        }

        return stationList;
    }

    private static String[] initLineNames(String lineName) {
        if (lineName.equals("2호선")) {
            return line2;
        }
        if (lineName.equals("3호선")) {
            return line3;
        }

        return lineSinbundang;
    }

    private static int[] initDistanceInLine(String lineName) {

        if (lineName.equals("2호선")) {
            return line2Distance;
        }
        if (lineName.equals("3호선")) {
            return line3Distance;
        }
        return lineSinbundangDistance;
    }

    private static int[] initTimeInLine(String lineName) {
        if (lineName.equals("2호선")) {
            return line2Time;
        }
        if (lineName.equals("3호선")) {
            return line3Time;
        }
        return lineSinbundangTime;
    }

    private static void initStation() {
        for (String station : stations) {
            StationRepository.addStation(new Station(station));
        }
    }

}
