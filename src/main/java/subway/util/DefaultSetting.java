package subway.util;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.util.enums.DefaultLines;
import subway.util.enums.DefaultStations;

public class DefaultSetting {

    public static void defaultSetting() {
        for (DefaultStations ds : DefaultStations.values()) {
            StationRepository.addStation(new Station(ds.getName()));
        }

        for (DefaultLines dl : DefaultLines.values()) {
            LineRepository.addLine(new Line(dl.getName()));
        }

        Line line2 = LineRepository.findLineByName(DefaultLines.LINE2.getName());
        line2.addStation(DefaultStations.KYODAE.getName());
        line2.addStation(DefaultStations.GANGNAM.getName());
        line2.addStation(DefaultStations.YEOKSAM.getName());

        Line line3 = LineRepository.findLineByName(DefaultLines.LINE3.getName());
        line3.addStation(DefaultStations.KYODAE.getName());
        line3.addStation(DefaultStations.NORTH_TERMINAL.getName());
        line3.addStation(DefaultStations.YANGJAE.getName());
        line3.addStation(DefaultStations.MAEBONG.getName());

        Line sinBunDang = LineRepository.findLineByName(DefaultLines.SINBUNDANG_LINE.getName());
        sinBunDang.addStation(DefaultStations.GANGNAM.getName());
        sinBunDang.addStation(DefaultStations.YANGJAE.getName());
        sinBunDang.addStation(DefaultStations.YANGJAE_CITIZEN_FOREST.getName());

        StationRepository.findStationByName(DefaultStations.KYODAE.getName())
                .addSection(DefaultStations.GANGNAM.getName(), 2, 3)
                .addSection(DefaultStations.NORTH_TERMINAL.getName(), 3, 2);
        StationRepository.findStationByName(DefaultStations.GANGNAM.getName())
                .addSection(DefaultStations.KYODAE.getName(), 2, 3)
                .addSection(DefaultStations.YEOKSAM.getName(), 2, 3)
                .addSection(DefaultStations.YANGJAE.getName(), 2, 8);
        StationRepository.findStationByName(DefaultStations.YEOKSAM.getName())
                .addSection(DefaultStations.GANGNAM.getName(), 2, 3);

        StationRepository.findStationByName(DefaultStations.NORTH_TERMINAL.getName())
                .addSection(DefaultStations.KYODAE.getName(), 3, 2)
                .addSection(DefaultStations.YANGJAE.getName(), 6, 5);
        StationRepository.findStationByName(DefaultStations.YANGJAE.getName())
                .addSection(DefaultStations.NORTH_TERMINAL.getName(), 6, 5)
                .addSection(DefaultStations.MAEBONG.getName(), 1, 1)
                .addSection(DefaultStations.GANGNAM.getName(), 2, 8)
                .addSection(DefaultStations.YANGJAE_CITIZEN_FOREST.getName(), 10, 3);
        StationRepository.findStationByName(DefaultStations.MAEBONG.getName())
                .addSection(DefaultStations.YANGJAE.getName(), 1, 1);
        StationRepository.findStationByName(DefaultStations.YANGJAE_CITIZEN_FOREST.getName())
                .addSection(DefaultStations.YANGJAE.getName(), 10, 3);
    }
}
