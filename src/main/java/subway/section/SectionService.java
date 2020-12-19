package subway.section;

import java.util.List;

public class SectionService {
    public void addSections(Sections sections) {
        List<Section> sectionList = sections.getSections();
        for (Section section : sectionList) {
            SectionRepository.addSection(section);
        }
    }
}
