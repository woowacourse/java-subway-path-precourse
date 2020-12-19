package subway.util;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.util.enums.DefaultLines;
import subway.util.enums.DefaultStations;

public class DefaultSetting {
    private static final String KYODAE = "교대역";
    private static final String GANGNAM = "강남역";
    private static final String YEOKSAM = "역삼역";
    private static final String NORTH_TERMINAL = "남부터미널역";
    private static final String YANGJAE = "양재역";
    private static final String YANGJAE_CITIZEN_FOREST = "양재시민의숲역";
    private static final String MAEBONG = "매봉역";
    private static final String LINE2 = "2호선";
    private static final String LINE3 = "3호선";
    private static final String SINBUNDANG_LINE = "신분당선";

    public static void defaultSetting() {
        for (DefaultStations ds : DefaultStations.values()) {
            StationRepository.addStation(new Station(ds.getName()));
        }

        for (DefaultLines dl : DefaultLines.values()) {
            LineRepository.addLine(new Line(dl.getName()));
        }

        Line line2 = LineRepository.findLineByName(LINE2);
        line2.addStation(KYODAE);
        line2.addStation(GANGNAM);
        line2.addStation(YEOKSAM);

        Line line3 = LineRepository.findLineByName(LINE3);
        line3.addStation(KYODAE);
        line3.addStation(NORTH_TERMINAL);
        line3.addStation(YANGJAE);
        line3.addStation(MAEBONG);

        Line sinBunDang = LineRepository.findLineByName(SINBUNDANG_LINE);
        sinBunDang.addStation(GANGNAM);
        sinBunDang.addStation(YANGJAE);
        sinBunDang.addStation(YANGJAE_CITIZEN_FOREST);

        DistanceRouteSearch.addDisTanceEdgeWeight(KYODAE, GANGNAM, 2);
        DistanceRouteSearch.addDisTanceEdgeWeight(GANGNAM, YEOKSAM, 2);
        DistanceRouteSearch.addDisTanceEdgeWeight(KYODAE, NORTH_TERMINAL, 3);
        DistanceRouteSearch.addDisTanceEdgeWeight(NORTH_TERMINAL, YANGJAE, 6);
        DistanceRouteSearch.addDisTanceEdgeWeight(YANGJAE, MAEBONG, 1);
        DistanceRouteSearch.addDisTanceEdgeWeight(GANGNAM, YANGJAE, 2);
        DistanceRouteSearch.addDisTanceEdgeWeight(YANGJAE, YANGJAE_CITIZEN_FOREST, 10);
    }
}
