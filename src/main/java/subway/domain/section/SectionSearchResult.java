package subway.domain.section;

import java.util.List;

public class SectionSearchResult {
    List<String> sections;
    double distance;
    double time;

    public SectionSearchResult(List<String> sections, double distance, double time) {
        this.sections = sections;
        this.distance = distance;
        this.time = time;
    }
}
