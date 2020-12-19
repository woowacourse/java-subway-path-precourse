package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();
    Line line=new Line();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }
    public Line getLine(String tmpSaveLine) {
        for(Line line:lines) {
            if(line.getName().equals(tmpSaveLine)) {
                return line;
            }
        }
        return null;
    }
    public static void deleteAll() {
        lines.clear();
    }
    public void initializeLine(String tmpSaveLine,List<String> tmpSaveStations){
        addLine(new Line(tmpSaveLine));
        line.setStations(tmpSaveStations);
    }
}
