package subway.domain;

import java.util.*;

public class Station {
    private String name;
    private List<ConnectStationNode> connectStationNodes = new ArrayList<>();

    private Station(String name) {
        this.name = name;
    }

    public static Station create(String name){
        return new Station(name);
    }

    public void addConnectStations(final ConnectStationNode connectStationNode){
        connectStationNodes.add(connectStationNode);
    }

    public String getName() {
        return name;
    }

    public boolean isEqualName(String name){
        return name.equals(this.name);
    }

    public List<ConnectStationNode> getConnectStationNodes() {
        return Collections.unmodifiableList(connectStationNodes);
    }

    public String toString(){
        return name;
    }
}
