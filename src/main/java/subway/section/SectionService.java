package subway.section;

import subway.station.Station;

import java.util.List;

public class SectionService {
    private static final int ZERO = 0;

    public void addSections(Sections sections) {
        List<Section> sectionList = sections.getSections();
        for (Section section : sectionList) {
            SectionRepository.addSection(section);
        }
    }

    public int getSectionTime(Station start, Station end) {
        List<Section> sections = SectionRepository.sections();
        for (Section section : sections) {
            if (section.getStartStation().equals(start) && section.getEndStation().equals(end)) {
                return section.getTime();
            }
        }
        return ZERO;
    }

    public int getSectionDistance(Station start, Station end) {
        List<Section> sections = SectionRepository.sections();
        for (Section section : sections) {
            if (section.getStartStation().equals(start) && section.getEndStation().equals(end)) {
                return section.getDistance();
            }
        }
        return ZERO;
    }
}
