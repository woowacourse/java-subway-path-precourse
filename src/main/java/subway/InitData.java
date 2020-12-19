package subway;

import subway.domain.data.Line;
import subway.domain.data.LineRepository;
import subway.domain.data.Station;
import subway.domain.data.StationRepository;

import java.util.ArrayList;
import java.util.List;

public class InitData {

    public static void initData() {
        initStation();
        initLine();
        //initPath();
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
            lineList.add(line);
        }

        return lineList;
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
        String[] line2 = {"교대역", "강남역", "역삼역"};
        String[] line3 = {"교대역", "남부터미널역", "양재역", "매봉역"};
        String[] lineSinbundang = {"강남역", "양재역", "양재시민의숲역"};

        if (lineName.equals("2호선")) {
            return line2;
        }
        if (lineName.equals("3호선")) {
            return line3;
        }

        return lineSinbundang;
    }

    private static void initStation() {
        String[] stations = {"교대역", "강남역", "역삼역"
                , "남부터미널역", "양재역", "양재시민의숲역", "매봉역"};

        for (String station : stations) {
            StationRepository.addStation(new Station(station));
        }
    }

}
