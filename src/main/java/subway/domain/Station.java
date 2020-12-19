package subway.domain;

import java.util.Objects;

public class Station {
    private String name;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Station)) {
            return false;
        }
        Station c = (Station) o;
        return c.getName().equals(((Station) o).getName());
    }

    @Override
    public int hashCode(){
        return Objects.hash(name);
    }
}
