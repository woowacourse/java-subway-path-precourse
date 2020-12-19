package subway.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Line implements Comparable<Line> {

    private String name;
    private List<Station> stations = new LinkedList<>();

    private Line(String name) {
        this.name = name;
    }

    public static Line of(String name) {
        return new Line(name);
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
        Line line = (Line) o;
        return Objects.equals(getName(), line.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public int compareTo(Line o) {
        return name.compareTo(o.name);
    }
}
