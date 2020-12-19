package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Sections {
    List<Section> sections;

    public Sections(){
        sections = new ArrayList<>();
    }

    public void addSection(Section section){
        sections.add(section);
    }
}
