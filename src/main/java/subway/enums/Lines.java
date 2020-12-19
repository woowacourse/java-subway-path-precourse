package subway.enums;

import subway.domain.Line;
import subway.domain.LineRepository;

import java.util.Arrays;

public enum Lines {
    LINE_2("2호선"),
    LINE_3("3호선"),
    LINE_SINBUNDANG("신분당선");

    private String name;

    Lines(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void initializeLines() {
        Arrays.stream(Lines.values())
                .map(Lines::getName)
                .map(Line::new)
                .forEach(LineRepository::addLine);;
    }
}
