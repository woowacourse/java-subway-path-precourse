package subway.domain;

public class Line {
    private String name;

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isSameNameThan(String comparedName) {
        return name.equals(comparedName);
    }

    // 추가 기능 구현
}
