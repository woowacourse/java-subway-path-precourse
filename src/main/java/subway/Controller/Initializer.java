package subway.Controller;

import java.util.Arrays;
import java.util.List;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class Initializer {

    private static List<String> INITIALSTATION = Arrays
        .asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
    private static List<String> INITIALLINE = Arrays.asList("2호선", "3호선", "신분당선");
    private static List<String> LINETWO = Arrays.asList("교대역", "강남역", "역삼역");
    private static List<String> LINETHREE = Arrays.asList("교대역", "남부터미널역", "양재역", "매봉역");
    private static List<String> LINESHINBUNDANG = Arrays.asList("강남역", "양재역", "양재시민의숲역");
    private static List<List<String>> INITIALLINESTATION = Arrays
        .asList(LINETWO, LINETHREE, LINESHINBUNDANG);

    public static void initializeBaseSetting() {
        initializeLine(INITIALLINE);
        initializeStation(INITIALSTATION);
    }

    private static void initializeStation(List<String> INITIALSTATION) {
        for (String stationName : INITIALSTATION) {
            Station station = new Station(stationName);
            StationRepository.addStation(station);
        }
    }

    private static void initializeLine(List<String> INITIALLINE) {
        for (int i = 0; i < INITIALLINE.size(); i++) {
            Line line = new Line(INITIALLINE.get(i));
            line.addLineStation(INITIALLINESTATION.get(i));
            LineRepository.addLine(line);
        }
    }
}
