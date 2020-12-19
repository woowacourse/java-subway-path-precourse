package subway.domain.section;

import java.util.List;

public class SectionsAndTime {
    List<String> sections;
    double time;

    public SectionsAndTime(List<String> sections, double time) {
        this.sections = sections;
        this.time = time;
    }

    public List<String> getSections() {
        return sections;
    }

    public double getTime() {
        return time;
    }
}
