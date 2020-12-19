package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

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

    public static void setUp() {
        setUpStation();
        setUpLine();
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
}
