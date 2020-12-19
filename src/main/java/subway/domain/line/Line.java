package subway.domain.line;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import subway.domain.section.Section;

public class Line implements Comparable<Line> {

    private String name;
    private List<Section> sections = new LinkedList<>();

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

    public boolean isMatchName(String name) {
        return this.name.equals(name);
    }

    public void addSection(Section section) {
        if (sections.contains(section)) {
            throw new IllegalArgumentException("[ERROR] 이미 노선에 존재하는 구간입니다.");
        }
        sections.add(section);
    }
}
