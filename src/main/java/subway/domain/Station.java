package subway.domain;

public class Station {
    private String name;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isName(String name) {
        return this.name.equals(name);
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Station) {
            return ((Station) o).name.equals(this.name);
        }
        return false;
    }
}
