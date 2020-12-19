package subway.domain.line;

import java.util.List;
import subway.domain.section.Section;
import subway.domain.station.Station;

public class Line {
    private String name;
    private List<Station> stations; 
    private List<Section> sections;

    public Line(String name, List<Station> stations, List<Section> sections) {
        this.name = name;
        this.stations = stations;
        this.sections = sections;
    }

    public String getName() {
        return name;
    }

    public boolean containsAll(Station startStation, Station endStation) {
        if (stations.contains(startStation) && stations.contains(endStation)) {
            return true;
        }
        return false;
    }
}
