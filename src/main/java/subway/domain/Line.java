package subway.domain;

import java.util.ArrayList;
import java.util.List;


public class Line {
    private String name;
    private static final List<Station> stations = new ArrayList<>();
    private static final List<Integer> distance = new ArrayList<>();
    private static final List<Integer> time = new ArrayList<>();
    public Line() {
    }
    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setStations(List<String> tmpSaveStation) {
        for(int i=0;i<tmpSaveStation.size();i++){
            stations.add(new Station(tmpSaveStation.get(i)));
        }
    }
    public void setTime(List<Integer> tmpSaveTime) {
        for(int i=0;i<tmpSaveTime.size();i++) {
            time.add(tmpSaveTime.get(i));
        }
    }
    public void setDistance(List<Integer> tmpSaveDistance) {
        for(int i=0;i< tmpSaveDistance.size();i++) {
            distance.add(tmpSaveDistance.get(i));
        }
    }
    // 추가 기능 구현
}
