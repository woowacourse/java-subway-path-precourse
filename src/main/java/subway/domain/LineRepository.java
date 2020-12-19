package subway.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
	
	static List<String> line2_stations = new ArrayList<String>(Arrays.asList("교대역","강남역","역삼역"));
	static List<String> line3_stations = new ArrayList<String>(Arrays.asList("교대역","남부터미널역","양재역","매봉역"));
	static List<String> line_sinbundang_stations = new ArrayList<String>(Arrays.asList("강남역","양재역","양재시민의숲역"));
	static int[] line2_distace = {2,2};
	static int[] line2_times = {2,3};
	static int[] line3_distance = {3,6,1};
	static int[] line3_times = {2,5,1};
	static int[] line_sinbundang_distance = {2,10};
	static int[] line_sinbundang_times = {8,3};
	static Line line_2 = new Line("2호선", line2_stations,line2_distace, line2_times);
	static Line line_3 = new Line("3호선", line3_stations,line3_distance,line3_times);
	static Line line_sinbundang = new Line("신분당선", line_sinbundang_stations,line_sinbundang_distance,line_sinbundang_times);
	
    private static final List<Line> lines = new ArrayList<>(Arrays.asList(line_2,line_3,line_sinbundang));
	
    //private static final List<Line> lines = new ArrayList<>();

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
