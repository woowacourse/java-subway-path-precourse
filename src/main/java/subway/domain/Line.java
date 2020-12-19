package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private String name;
    private List<Section> sectionList;

    public Line(String name) {
        this.name = name;
        this.sectionList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addSection(Section section) {
        sectionList.add(section);
    }
}
