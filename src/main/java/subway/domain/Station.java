package subway.domain;

public class Station {
    private String name;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isSameName(String name){
        return this.name.equals(name);
    }

    public boolean isSameStation(Station station){
        return this == station;
    }

}
