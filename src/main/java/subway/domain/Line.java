package subway.domain;

import java.util.List;

public class Line {
    private String name;
    private List<Edge> edges;

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
}
