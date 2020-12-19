package subway.Initialization;

import subway.domain.Section;
import subway.domain.Station;
import java.util.Arrays;
import java.util.List;

public enum SectionInitialization {
    LINE_TWO_SECTIONS(
            LineInitialization.LINE_TWO,
            new Section(
                    new Station(StationInitialization.GYODAE.getName()),
                    new Station(StationInitialization.GANGNAM.getName()),
                    2,
                    3
            ),
            new Section(
                    new Station(StationInitialization.GANGNAM.getName()),
                    new Station(StationInitialization.YEOGSAM.getName()),
                    2,
                    3
            )
    ),
    LINE_THREE_SECTIONS(
            LineInitialization.LINE_THREE,
            new Section(
                    new Station(StationInitialization.GYODAE.getName()),
                    new Station(StationInitialization.NAMBU_TERMINAL.getName()),
                    3,
                    2
            ),
            new Section(
                    new Station(StationInitialization.NAMBU_TERMINAL.getName()),
                    new Station(StationInitialization.YANGJAE.getName()),
                    6,
                    5
            ),
            new Section(
                    new Station(StationInitialization.YANGJAE.getName()),
                    new Station(StationInitialization.MAEBONG.getName()),
                    1,
                    1
            )
    ),
    SINBUNDANG_LINE(
            LineInitialization.SINBUNDANG_LINE,
            new Section(
                    new Station(StationInitialization.GANGNAM.getName()),
                    new Station(StationInitialization.YANGJAE.getName()),
                    2,
                    8
            ),
            new Section(
                    new Station(StationInitialization.YANGJAE.getName()),
                    new Station(StationInitialization.YANGJAE_CITIZEN_FOREST.getName()),
                    10,
                    3
            )
    );

    private List<Section> sections;
    private LineInitialization lineInitialization;

    SectionInitialization(LineInitialization lineInitialization, Section... sections) {
        this.lineInitialization = lineInitialization;
        this.sections = Arrays.asList(sections);
    }

    public List<Section> sections() {
        return sections;
    }

    public static SectionInitialization getSectionInitialization(LineInitialization lineInitialization) {
        return Arrays.stream(SectionInitialization.values()).filter(
                sectionInitialization -> sectionInitialization.lineInitialization.equals(lineInitialization))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
