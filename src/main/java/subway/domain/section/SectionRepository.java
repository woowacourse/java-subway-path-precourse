package subway.domain.section;

import subway.exception.ErrorCode;
import subway.exception.SectionException;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class SectionRepository {
    private static final Map<String, Section> sections = new ConcurrentHashMap<>();

    public SectionRepository() {
    }

    public Section addSection(Section section) {
        if (findByName(section.getLineName()) != null) {
            throw new SectionException(ErrorCode.LINE_ALREADY_EXIST);
        }
        sections.put(section.getLineName(), section);
        return section;
    }

    public Section findByName(String lineName) {
        Section section = sections.get(lineName);
        return section;
    }

    public List<Section> sections() {
        return sections.values().stream().collect(Collectors.toList());
    }

    public void removeAll() {
        sections.clear();
    }
}
