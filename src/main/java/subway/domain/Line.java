package subway.domain;

public class Line {
    private String name;

    private Line(String name) {
        this.name = name;
    }

    public static Line from(String name) {
        Line line = new Line(name);
        LineRepository.addLine(line);
        return line;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
}
