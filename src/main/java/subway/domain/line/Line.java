package subway.domain.line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import subway.domain.section.Section;
import subway.domain.section.SectionRepository;
import subway.domain.station.Station;

public class Line {
    private String name;
    private List<Station> stations;

    public Line(String name, List<Station> stations) {
        this.name = name;
        this.stations = new ArrayList<>(stations);
    }

    public List<Station> getStations() {
        return Collections.unmodifiableList(stations);
    }

    public String getName() {
        return name;
    }

    public List<Section> getSections() {
        List<Section> sections = new ArrayList<>();
        for (int i = 0; i < stations.size() - 1; i++) {
            Section section
                = SectionRepository.getSectionByStations(stations.get(i), stations.get(i + 1));
            sections.add(section);
        }
        return sections;
    }
}
