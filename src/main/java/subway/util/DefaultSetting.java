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

        StationRepository.findStationByName(KYODAE)
                .addSection(GANGNAM, 2, 3)
                .addSection(DefaultStations.NORTH_TERMINAL.getName(), 3, 2);
        StationRepository.findStationByName(GANGNAM)
                .addSection(KYODAE, 2, 3)
                .addSection(YEOKSAM, 2, 3)
                .addSection(YANGJAE, 2, 8);
        StationRepository.findStationByName(YEOKSAM)
                .addSection(GANGNAM, 2, 3);
        StationRepository.findStationByName(NORTH_TERMINAL)
                .addSection(KYODAE, 3, 2)
                .addSection(YANGJAE, 6, 5);
        StationRepository.findStationByName(YANGJAE)
                .addSection(NORTH_TERMINAL, 6, 5)
                .addSection(MAEBONG, 1, 1)
                .addSection(GANGNAM, 2, 8)
                .addSection(YANGJAE_CITIZEN_FOREST, 10, 3);
        StationRepository.findStationByName(MAEBONG)
                .addSection(YANGJAE, 1, 1);
        StationRepository.findStationByName(YANGJAE_CITIZEN_FOREST)
                .addSection(YANGJAE, 10, 3);

        DistanceRouteSearch.addDistanceEdgeWeight(KYODAE, GANGNAM, 2);
        DistanceRouteSearch.addDistanceEdgeWeight(GANGNAM, YEOKSAM, 2);
        DistanceRouteSearch.addDistanceEdgeWeight(KYODAE, NORTH_TERMINAL, 3);
        DistanceRouteSearch.addDistanceEdgeWeight(NORTH_TERMINAL, YANGJAE, 6);
        DistanceRouteSearch.addDistanceEdgeWeight(YANGJAE, MAEBONG, 1);
        DistanceRouteSearch.addDistanceEdgeWeight(GANGNAM, YANGJAE, 2);
        DistanceRouteSearch.addDistanceEdgeWeight(YANGJAE, YANGJAE_CITIZEN_FOREST, 10);

        TimeRouteSearch.addDistanceEdgeWeight(KYODAE, GANGNAM, 3);
        TimeRouteSearch.addDistanceEdgeWeight(GANGNAM, YEOKSAM, 3);
        TimeRouteSearch.addDistanceEdgeWeight(KYODAE, NORTH_TERMINAL, 2);
        TimeRouteSearch.addDistanceEdgeWeight(NORTH_TERMINAL, YANGJAE, 5);
        TimeRouteSearch.addDistanceEdgeWeight(YANGJAE, MAEBONG, 1);
        TimeRouteSearch.addDistanceEdgeWeight(GANGNAM, YANGJAE, 8);
        TimeRouteSearch.addDistanceEdgeWeight(YANGJAE, YANGJAE_CITIZEN_FOREST, 3);
    }
}
