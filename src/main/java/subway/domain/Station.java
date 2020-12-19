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
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Station paramObj = (Station) obj;
        return this.name.equals(paramObj.name);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}
