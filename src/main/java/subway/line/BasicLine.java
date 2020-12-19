package subway.line;

import subway.cost.Cost;
import subway.section.Section;
import subway.section.Sections;
import subway.station.StationRepository;

import java.util.Arrays;

public enum BasicLine {
    LINETWO("2호선", new Sections(Arrays.asList(
            new Section(StationRepository.findByName("교대역"),
                    StationRepository.findByName("강남역"),
                    new Cost(2, 3)),
            new Section(StationRepository.findByName("강남역"),
                    StationRepository.findByName("역삼역"),
                    new Cost(2, 3))
    ))),
    LINETHREE("3호선", new Sections(Arrays.asList(
            new Section(StationRepository.findByName("교대역"),
                    StationRepository.findByName("남부터미널역"),
                    new Cost(3, 2)),
            new Section(StationRepository.findByName("남부터미널역"),
                    StationRepository.findByName("양재역"),
                    new Cost(6, 5)),
            new Section(StationRepository.findByName("양재역"),
                    StationRepository.findByName("매봉역"),
                    new Cost(1, 1))
    ))),
    DXLINE("신분당선", new Sections(Arrays.asList(
            new Section(StationRepository.findByName("강남역"),
                    StationRepository.findByName("양재역"),
                    new Cost(2, 8)),
            new Section(StationRepository.findByName("양재역"),
                    StationRepository.findByName("양재시민의숲역"),
                    new Cost(10, 3))
    )));

    private String name;
    private Sections sections;

    BasicLine(String name, Sections sections) {
        this.name = name;
        this.sections = sections;
    }

    public String getName() {
        return name;
    }

    public Sections getSections() {
        return sections;
    }
}
