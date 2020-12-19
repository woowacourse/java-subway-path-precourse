package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Sections {
    private static List<Station> sections = new ArrayList<>();

    Sections(List<Station> sections) {
        this.sections = sections;
    }

    public static int size() {
        return sections.size();
    }

}
