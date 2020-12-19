package subway.domain;

import java.util.Objects;

public class Line {

    private final String name;

    private final LineDirection lineDirection;

    public Line(String name, LineDirection lineDirection) {
        this.name = name;
        this.lineDirection = lineDirection;
    }

    public String getName() {
        return name;
    }

    public LineDirection getLineDirection() {
        return lineDirection;
    }

    // 추가 기능 구현
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Line)) {
            return false;
        }
        Line line = (Line) o;
        return Objects.equals(getName(), line.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
