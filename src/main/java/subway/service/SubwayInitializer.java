package subway.service;

import subway.domain.Distances;
import subway.domain.ElapsedTimes;
import subway.domain.Line;
import subway.domain.LineDirection;
import subway.domain.LineRepository;
import subway.domain.StationRepository;

public class SubwayInitializer {

    public static final String SECOND_LINE = "2호선";
    public static final String THIRD_LINE = "3호선";
    public static final String SINBUNDANG_LINE = "신분당선";
    public static final String KYODAE_STATION = "교대역";
    public static final String KANGNAME_STATION = "강남역";
    public static final String YEOKSAM_STATION = "역삼역";
    public static final String NAMBU_TERMINAL_STATION = "남부터미널역";
    public static final String YANGJAE_STATION = "양재역";
    public static final String MAEBONG_STATION = "매봉역";
    public static final String YANGJAE_CITIZEN_STATION = "양재시민의숲역";

    private SubwayInitializer() {}

    public static SubwayService initialize() {
        StationRepository secondLineRepository = new StationRepository().addStations(KYODAE_STATION,
                KANGNAME_STATION, YEOKSAM_STATION);
        StationRepository thirdLineRepository = new StationRepository().addStations(KYODAE_STATION,
                NAMBU_TERMINAL_STATION, YANGJAE_STATION, MAEBONG_STATION);
        StationRepository sinbundangLineRepository =
                new StationRepository().addStations(KANGNAME_STATION,
                        YANGJAE_STATION, YANGJAE_CITIZEN_STATION);

        Distances secondLineDistances = new Distances(2, 2);
        Distances thirdLineDistances = new Distances(3, 6, 1);
        Distances sinbundangLineDistances = new Distances(2, 10);

        ElapsedTimes secondLineTimes = new ElapsedTimes(3, 3);
        ElapsedTimes thirdLineTimes = new ElapsedTimes(2, 5, 1);
        ElapsedTimes sinbundangLineTimes = new ElapsedTimes(8, 3);

        LineDirection secondLineDirection =
                new LineDirection(secondLineRepository, secondLineDistances, secondLineTimes);
        LineDirection thirdLineDirection =
                new LineDirection(thirdLineRepository, thirdLineDistances, thirdLineTimes);
        LineDirection sinbundangLineDirection =
                new LineDirection(sinbundangLineRepository, sinbundangLineDistances,
                        sinbundangLineTimes);

        Line secondLine = new Line(SECOND_LINE, secondLineDirection);
        Line thirdLine = new Line(THIRD_LINE, thirdLineDirection);
        Line sinbundangLine = new Line(SINBUNDANG_LINE, sinbundangLineDirection);

        LineRepository lineRepository = new LineRepository().addLines(secondLine, thirdLine, sinbundangLine);

        return new SubwayService(lineRepository);
    }
}
