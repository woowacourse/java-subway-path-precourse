package subway.line;

import subway.section.Section;
import subway.section.Sections;

import java.util.ArrayList;
import java.util.List;

public class LineController {
    private LineService lineService;

    public LineController() {
        this.lineService = new LineService();
    }

    public void lineInitialize() {
        List<Line> lines = new ArrayList<>();

        for (BasicLine basicLine : BasicLine.values()) {
            String lineName = basicLine.getName();
            Sections sections = basicLine.getSections();
            Line line = new Line(lineName, sections);
            lines.add(line);
        }
        lineService.addAllLine(lines);
    }
}
