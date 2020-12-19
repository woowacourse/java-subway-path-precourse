package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sections {
    private List<Section> sections;

    public Sections(){
        sections = new ArrayList<>();
    }

    public void addSection(Section section){
        sections.add(section);
    }

    public List<Section> getUnmodifiableList(){
        return Collections.unmodifiableList(sections);
    }

    public void addAll(List<Section> others){
        sections.addAll(others);
    }
}
