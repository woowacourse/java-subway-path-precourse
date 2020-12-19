package subway.domain.line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import subway.domain.section.Section;
import subway.domain.station.Station;

public class Line {
    private String name;
    private List<Station> stations;
    private List<Section> sections;

    public Line(String name, List<Station> stations, List<Section> sections) {
        this.name = name;
        this.stations = new ArrayList<>(stations);
        this.sections = new ArrayList<>(sections);
    }

    public List<Station> getStations() {
        return Collections.unmodifiableList(stations);
    }

    public List<Section> getSections() {
        return Collections.unmodifiableList(sections);
    } 

    public String getName() {
        return name;
    }
}
