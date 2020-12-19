package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Sections {
    private static List<Station> sections = new ArrayList<>();

//    public static void addSection(Station station, int index) {
//        if (!sections.contains(station)) {
//            sections.add(index, station);
//            return;
//        }
//        throw new IllegalArgumentException("[ERROR] 같은 역이 이미 노선에 존재합니다.");
//    }

    Sections(List<Station> sections){
        this.sections = sections;
    }

    public static int size() {
        return sections.size();
    }

}
