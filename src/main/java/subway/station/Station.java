package subway.station;

public class Station {
    private String name;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isSameName(Station endStation) {
        return name.equals(endStation.getName());
    }
}
