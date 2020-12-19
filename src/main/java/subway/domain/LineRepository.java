package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final String[] LINES = {"2호선", "3호선", "신분당선"};
    private static final String[][] LINE_STATIONS = {{"교대역","강남역","역삼역"},{"교대역","남부터미널역","양재역"},
            {"강남역","양재역","양재시민의숲역"}};
    private static int INDEX = 0;

    private static final List<Line> lines = new ArrayList<>();

    static{
        for(String lineName : LINES){
            Line line = new Line(lineName);
            for(String stationName : LINE_STATIONS[INDEX]){
                line.addStation(new Station(stationName));
            }
            lines.add(line);
            INDEX++;
        }
    }


    public static List<Line> lines() {
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
