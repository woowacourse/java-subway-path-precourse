package subway.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Station {

    private String name;
    private List<Line> lines = new LinkedList<>();

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Station station = (Station) o;
        return getName().equals(((Station) o).getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public String toString() {
        return name;
    }

    // 추가 기능 구현
}
