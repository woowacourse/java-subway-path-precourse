package subway.domain;

import java.util.List;

public class Line {
    private String name;
    private List<String[]> edgesAndWeights;

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addEdgesAndWeights(List<String[]> edgesAndWeights) {
        this.edgesAndWeights = edgesAndWeights;
    }

    // 추가 기능 구현
}
