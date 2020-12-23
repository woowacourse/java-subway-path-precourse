package subway.domain;

public class Line {
    private final String name;
    private final LineStations stations;

    public Line(String name) {
        this.name = name;
        this.stations = new LineStations();
    }

    public String getName() {
        return name;
    }

    public void addLineStation(Station station) {
        stations.addLineStation(station);
    }

    @Override
    public boolean equals(Object object) {
        if (getClass() != object.getClass()) {
            return false;
        }
        boolean isEqualObject = false;
        Line line = (Line) object;
        if (getName().equals(line.getName())) {
            isEqualObject = true;
        }
        return isEqualObject;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;
        hashCode = prime * hashCode + getName().hashCode();
        return hashCode;
    }
}
