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



    }
}
