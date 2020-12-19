package subway.domain;

public class Station {
    private String name;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object object) {
        if (getClass() != object.getClass()) {
            return false;
        }
        boolean isEqualObject = false;
        Station station = (Station) object;
        if (getName().equals(station.getName())) {
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
