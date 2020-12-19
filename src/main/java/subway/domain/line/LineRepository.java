package subway.domain.line;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.section.Section;
import subway.domain.station.Station;

public class LineRepository {

    private static final List<Line> lines = new ArrayList<>();

    static {
        lines.add(new Line("2호선",
            new ArrayList<Station>(Arrays.asList(
                new Station("교대역"),
                new Station("강남역"),
                new Station("역삼역"))
            )));
        lines.add(new Line("3호선",
            new ArrayList<Station>(Arrays.asList(
                new Station("교대역"),
                new Station("남부터미널역"),
                new Station("양재역"),
                new Station("매봉역"))
            )));
        lines.add(new Line("신분당선",
            new ArrayList<Station>(Arrays.asList(
                new Station("강남역"),
                new Station("양재역"),
                new Station("양재시민의숲역"))
            )));
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
