package subway.line;

import subway.section.Section;
import subway.section.SectionService;
import subway.section.Sections;

import java.util.ArrayList;
import java.util.List;

public class LineController {
    private LineService lineService;
    private SectionService sectionService;

    public LineController() {
        this.lineService = new LineService();
        this.sectionService = new SectionService();
    }

    public void lineInitialize() {
        List<Line> lines = new ArrayList<>();

        for (BasicLine basicLine : BasicLine.values()) {
            String lineName = basicLine.getName();
            Sections sections = basicLine.getSections();
            Line line = new Line(lineName, sections);
            lines.add(line);
            sectionService.addSections(sections);
        }
        lineService.addAllLine(lines);
    }
}
