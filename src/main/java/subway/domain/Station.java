package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Station {
    private String name;
    private List<NodeData> nodeData = new ArrayList<>();

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public void addNodeData(String nextStation, int timeCost, int distanceCost){
        nodeData.add(new NodeData(new Station(nextStation), timeCost, distanceCost));
    }

    public List<NodeData> getNodeData(){
        return Collections.unmodifiableList(nodeData);
    }
}
