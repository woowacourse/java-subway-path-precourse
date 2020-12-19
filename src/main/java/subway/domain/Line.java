package subway.domain;

import java.util.List;

public class Line {
    private String name;
    private Sections sections;

//    public Line(String name, Station upStation, Station downStation) {
//        this.name = name;
//        this.sections.addSection(upStation, 0);
//        this.sections.addSection(downStation, 0);
//    }

    public Line(String name, List<Station> sections){
        this.name = name;
        this.sections = new Sections(sections);
    }

    public String getName() {
        return name;
    }
}
