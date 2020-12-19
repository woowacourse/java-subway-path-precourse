package subway.line;

import subway.section.Sections;

public class Line {
    private String name;
    private Sections sections;

//    public Line(String name) {
//        this.name = name;
//        this.sections = new Sections();
//    }

    public Line(String name, Sections sections) {
        this.name = name;
        this.sections = sections;
    }

    public String getName() {
        return name;
    }

    public Sections getSections() {
        return sections;
    }
}
