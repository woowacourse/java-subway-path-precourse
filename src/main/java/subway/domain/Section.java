package subway.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Section {

    private Set<String> stations = new HashSet<>();
    private int distance;
    private int costTime;

    public Section(String station1, String station2, int distance, int costTime) {
        stations.add(station1);
        stations.add(station2);
        this.distance = distance;
        this.costTime = costTime;
    }

    public boolean isInShortestPath(List<String> shortestPath) {
        for(int i=0; i<shortestPath.size()-1; i++) {
            if(stations.contains(shortestPath.get(i)) && stations.contains(shortestPath.get(i+1))) {
                return true;
            }
        }
        return false;
    }

    public Set<String> getStations() {
        return stations;
    }

    public int getDistance() {
        return distance;
    }

    public int getCostTime() {
        return costTime;
    }
}
