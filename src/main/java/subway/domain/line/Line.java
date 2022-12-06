package subway.domain.line;

public class Line {
    private String name;

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public boolean nameEquals(String input) {
        return name.equals(input);
    }

}
