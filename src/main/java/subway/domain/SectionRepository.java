package subway.domain;

import java.util.List;

public class SectionRepository {
    public static void addSection(Line line, Section section) {
        Line target = LineRepository.findByName(line.getName());
        target.addSection(section);
    }

    public static Sections allSections() {
        List<Line> lines = LineRepository.lines();
        Sections allSections = new Sections();
        for (Line line : lines) {
            allSections.addAll(line.getSections().getUnmodifiableList());
        }
        return allSections;
    }
}
