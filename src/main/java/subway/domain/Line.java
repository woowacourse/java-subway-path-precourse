package subway.domain;

public class Line {
    private String name;

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean matchName(String name){return this.name.equals(name);}

    // 추가 기능 구현
}
