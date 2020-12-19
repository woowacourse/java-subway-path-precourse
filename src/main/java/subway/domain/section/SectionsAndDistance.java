package subway.domain.section;

import java.util.List;

public class SectionsAndDistance {
    List<String> sections;
    double distance;

    public SectionsAndDistance(List<String> sections, double distance) {
        this.sections = sections;
        this.distance = distance;
    }

    public List<String> getSections() {
        return sections;
    }

    public double getDistances() {
        return distance;
    }
}
