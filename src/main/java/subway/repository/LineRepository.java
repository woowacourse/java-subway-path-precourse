package subway.repository;

import subway.domain.Line;
import subway.domain.Station;
import subway.util.constants.LineName;
import subway.util.constants.StationName;
import subway.util.exception.NoResourceException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static subway.util.message.ExceptionMessage.NO_RESOURCE_MESSAGE;

public class LineRepository {
    private static final LineRepository lineRepository = new LineRepository();
    private static final StationRepository stationRepository = StationRepository.getInstance();
    private LineRepository(){

    }

    public void initLine(){
        for (LineName lineName : LineName.values()) {
            Line line = Line.create(lineName.getKey());
            addLine(line);
        }
    }

    public static LineRepository getInstance(){
        return lineRepository;
    }
    private static final List<Line> lines = new ArrayList<>();

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

    public Line findByName(String name){
        return lines.stream()
                .filter(line -> line.isEqualName(name))
                .findFirst()
                .orElseThrow(() -> new NoResourceException(String.format(NO_RESOURCE_MESSAGE.getValue(), "해당 호선")));
    }
}
