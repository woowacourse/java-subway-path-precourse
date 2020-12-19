package subway;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.util.DefaultSetting;
import subway.util.enums.DefaultLines;
import subway.util.enums.DefaultStations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DefaultSettingTest {

    @BeforeAll
    public static void 초기값_세팅() {
        DefaultSetting.defaultSetting();
    }

    @Test
    public void 이호선_만들어졌다() {
        Line line2 = LineRepository.findLineByName(DefaultLines.LINE2.getName());
        assertEquals(line2.getName(), DefaultLines.LINE2.getName());
    }

    @Test
    public void 노선들_만들어졌다() {
        List<Line> lineList= LineRepository.lines();
        assertEquals(lineList.size(), 3);
    }

    @Test
    public void 역들_만들어졌다() {
        List<Station> stationList = StationRepository.stations();
        assertEquals(stationList.size(), 7);
    }

    @Test
    public void 구간_적용됐다() {
        Station station = StationRepository.findStationByName(DefaultStations.KYODAE.getName());
        assertEquals(station.sections().size(), 2);
    }

}
