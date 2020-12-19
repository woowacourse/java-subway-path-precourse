package subway.domain;

public class Line {
    private String name;
    private final Sections sections = new Sections();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public Sections getSections() {
        return sections;
    }
}
