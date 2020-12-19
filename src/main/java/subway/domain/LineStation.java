package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class LineStation {

    private Line line;
    private List<Station> stations;
    private List<Section> sectionInfos;

    public LineStation(Line line, List<Station> stations, List<String> sectionInfo) {
        this.line = line;
        this.stations = stations;
        List<Section> tempSectionList = new ArrayList<>();
        for (String s : sectionInfo) {
            tempSectionList.add(new Section(s));
        }
        sectionInfos = tempSectionList;
    }

    public Line getLine() {
        return line;
    }

    public List<Station> getStations() {
        return stations;
    }

    public  List<Section> getSectionInfos() {
        return sectionInfos;
    }

    @Override
    public String toString() {
        return "LineStation{" +
                "line=" + line +
                ", stations=" + stations +
                ", sectionInfos=" + sectionInfos +
                '}';
    }
}
