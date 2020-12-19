package subway.Controller;

import java.util.Arrays;
import java.util.List;
import subway.domain.DistanceWeightRepository;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.domain.TimeWeightRepository;

public class Initializer {

    private static List<String> INITIALSTATION = Arrays
        .asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
    private static List<String> INITIALLINE = Arrays.asList("2호선", "3호선", "신분당선");
    private static List<String> LINETWO = Arrays.asList("교대역", "강남역", "역삼역");
    private static int[] LINETWOTIME = {2, 3};
    private static int[] LINETWODISTANCE = {3, 3};
    private static List<String> LINETHREE = Arrays.asList("교대역", "남부터미널역", "양재역", "매봉역");
    private static int[] LINETHREETIME = {3, 6, 1};
    private static int[] LINETHREEDISTANCE = {2, 5, 1};
    private static List<String> LINESHINBUNDANG = Arrays.asList("강남역", "양재역", "양재시민의숲역");
    private static int[] LINESHINBUNDANGTIME = {2, 10};
    private static int[] LINESHINBUNDANGDISTANCE = {8, 3};
    private static List<List<String>> INITIALLINESTATION = Arrays
        .asList(LINETWO, LINETHREE, LINESHINBUNDANG);

    public static void setInitializeBaseSetting() {
        setInitializeLine(INITIALLINE);
        setInitializeStation(INITIALSTATION);
        setInitialVertex(INITIALSTATION);
        setInitialWeight(LINETWO, LINETWOTIME, LINETWODISTANCE);
        setInitialWeight(LINETHREE, LINETHREETIME, LINETHREEDISTANCE);
        setInitialWeight(LINESHINBUNDANG, LINESHINBUNDANGTIME, LINESHINBUNDANGDISTANCE);
    }

    private static void setInitializeStation(List<String> INITIALSTATION) {
        for (String stationName : INITIALSTATION) {
            Station station = new Station(stationName);
            StationRepository.addStation(station);
        }
    }

    private static void setInitializeLine(List<String> INITIALLINE) {
        for (int i = 0; i < INITIALLINE.size(); i++) {
            Line line = new Line(INITIALLINE.get(i));
            line.addLineStation(INITIALLINESTATION.get(i));
            LineRepository.addLine(line);
        }
    }

    private static void setInitialVertex(List<String> stationNames) {
        for (String stationName : stationNames) {
            TimeWeightRepository.addStation(stationName);
            DistanceWeightRepository.addStation(stationName);
        }
    }

    private static void setInitialWeight(List<String> lineNumber, int[] timeWeight,
        int[] distanceWeight) {
        for (int i = 0; i < lineNumber.size() - 1; i++) {
            TimeWeightRepository
                .setStationEdgeTime(lineNumber.get(i), lineNumber.get(i + 1), timeWeight[i]);
            DistanceWeightRepository
                .setStationEdgeDistance(lineNumber.get(i), lineNumber.get(i + 1),
                    distanceWeight[i]);
        }
    }
}
