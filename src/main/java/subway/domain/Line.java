package subway.domain;

import java.util.List;

public class Line {
    private String name;
    private Sections sections;

    public Line(String name, List<Station> sections) {
        this.name = name;
        this.sections = new Sections(sections);
    }

    public String getName() {
        return name;
    }
}
