package subway.setUp;

import subway.domain.Line;
import subway.repository.LineRepository;
import subway.domain.Section;
import subway.repository.SectionRepository;
import subway.domain.Station;
import subway.repository.StationRepository;
import subway.domain.Street;
import subway.domain.Time;

/**
 * @author yhh1056
 * @since 2020/12/19
 */
public class SetUp {
    private static final String GYODAE = "교대역";
    private static final String GANGNAM = "강남역";
    private static final String YEOKSAM = "역삼역";
    private static final String NAMBU_TERMINAL = "남부터미널역";
    private static final String YANGJAE = "양재역";
    private static final String YANGJAE_CITIZEN_FOREST = "양재시민의숲역";
    private static final String MAEBONG = "매봉역";

    private static final String TWO_LINE = "2호선";
    private static final String THREE_LINE = "3호선";
    private static final String SINBUNDANG_LINE = "신분당선";

    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FIVE = 5;
    private static final int SIX = 6;
    private static final int EIGHT = 8;
    private static final int TEN = 10;


    public static void setUp() {
        setUpStation();
        setUpLine();
        setUpSection();
    }

    public static void setUpStation() {
        StationRepository.addStation(new Station(GYODAE));
        StationRepository.addStation(new Station(GANGNAM));
        StationRepository.addStation(new Station(YEOKSAM));
        StationRepository.addStation(new Station(NAMBU_TERMINAL));
        StationRepository.addStation(new Station(YANGJAE));
        StationRepository.addStation(new Station(YANGJAE_CITIZEN_FOREST));
        StationRepository.addStation(new Station(MAEBONG));
    }

    public static void setUpLine() {
        setUpTwoLine();
        setUpThreeLine();
        setUpSinbundangLine();

        LineRepository.addLine(new Line(TWO_LINE));
        LineRepository.addLine(new Line(THREE_LINE));
        LineRepository.addLine(new Line(SINBUNDANG_LINE));
    }

    private static void setUpTwoLine() {
        Line twoLine = new Line(TWO_LINE);
        twoLine.addStationByName(GYODAE);
        twoLine.addStationByName(GANGNAM);
        twoLine.addStationByName(YEOKSAM);
    }

    private static void setUpThreeLine() {
        Line threeLine = new Line(THREE_LINE);
        threeLine.addStationByName(GYODAE);
        threeLine.addStationByName(NAMBU_TERMINAL);
        threeLine.addStationByName(YANGJAE);
        threeLine.addStationByName(MAEBONG);
    }

    private static void setUpSinbundangLine() {
        Line sinbundangLine = new Line(SINBUNDANG_LINE);
        sinbundangLine.addStationByName(GANGNAM);
        sinbundangLine.addStationByName(YANGJAE);
        sinbundangLine.addStationByName(YANGJAE_CITIZEN_FOREST);
    }

    private static void setUpSection() {
        setUpTwoSection();
        setUpThreeSection();
        setUpSinbundangSection();
    }

    private static void setUpTwoSection() {
        SectionRepository
            .addSection(createSection(GYODAE, GANGNAM, new Street(TWO), new Time(THREE)));
        SectionRepository
            .addSection(createSection(GANGNAM, YEOKSAM, new Street(TWO), new Time(THREE)));
    }

    private static void setUpThreeSection() {
        SectionRepository
                .addSection(createSection(GYODAE, NAMBU_TERMINAL, new Street(THREE), new Time(TWO)));
        SectionRepository
                .addSection(createSection(NAMBU_TERMINAL, YANGJAE, new Street(SIX), new Time(FIVE)));
        SectionRepository
                .addSection(createSection(YANGJAE, MAEBONG, new Street(ONE), new Time(ONE)));
    }

    private static void setUpSinbundangSection() {
        SectionRepository
            .addSection(createSection(GANGNAM, YANGJAE, new Street(TWO), new Time(EIGHT)));
        SectionRepository
            .addSection(createSection(YANGJAE, YANGJAE_CITIZEN_FOREST, new Street(TEN), new Time(THREE)));
    }

    private static Section createSection(String startName, String finishName, Street street,
        Time time) {
        return new Section(startName, finishName, street, time);
    }
}
