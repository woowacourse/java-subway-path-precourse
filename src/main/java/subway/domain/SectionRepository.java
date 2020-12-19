package subway.domain;

public class SectionRepository {
    public static void addSection(Line line, Section section) {
        Line target = LineRepository.findByName(line.getName());
        target.addSection(section);
    }
}
