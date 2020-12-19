package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Sections {
    private final List<Section> sections;

    public Sections(List<Section> sections){
        this.sections = sections;
    }

    public int getTotalDistance(){
        return sections.stream().mapToInt(Section::getDistance).sum();
    }

    public int getTotalDuration(){
        return sections.stream().mapToInt(Section::getDuration).sum();
    }

    public List<String> getStationsName(){
        List<String> stationsName = new ArrayList<>();

        sections.forEach(section -> stationsName.add(section.getDepartureStation().getName()));
        stationsName.add(sections.get(sections.size()-1).getArrivalStation().getName());

        return stationsName;
    }
}