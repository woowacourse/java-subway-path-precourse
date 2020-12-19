package subway.domain;

public class Line {
    private String name;
    private Sections sections;

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addSection(Section section){
        sections.addSection(section);
    }
}
