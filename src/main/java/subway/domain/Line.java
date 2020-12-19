package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private String name;
    private static final List<Section> sections = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addSection(Section section) {
        sections.add(section);
    }
    
    public static List<Section> sections(){
    	return sections;
    }
}
