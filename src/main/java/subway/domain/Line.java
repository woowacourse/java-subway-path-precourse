package subway.domain;

public class Line {
    private String name;
    private Station[] stations;
    private int[] length;
    private int[] time;
    
    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
}
