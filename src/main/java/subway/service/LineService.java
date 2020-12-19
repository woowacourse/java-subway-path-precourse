package subway.service;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.PathRepository;
import subway.domain.Section;
import subway.domain.SectionRepository;

public class LineService {

    public static void addSectionInLine(Line line, Section section) {
        LineRepository.addSectionInLine(line, section);
        SectionRepository.addSection(section);
        PathRepository.addSection(section);
    }
}
