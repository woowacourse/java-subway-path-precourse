package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class InitialSetter {
    public void setInitialSubwayInfo() {
        setInitialStation();
        setInitialLine();
    }

    private void setInitialStation() {
        String[] stations = { "교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역" };
        for (String station : stations) {
            StationRepository.addStation(new Station(station));
        }
    }

    private void setInitialLine() {
        setLineNo2(new Line("2호선"));
        setLineNo3(new Line("3호선"));
        setLineShinBundang(new Line("신분당선"));
    }

    private void setLineNo2(Line lineNo2) {
        String[] stations = { "교대역", "강남역", "역삼역" };
        LineRepository.addLine(addStationToLine(stations, lineNo2));
    }

    private void setLineNo3(Line lineNo3) {
        String[] stations = { "교대역", "남부터미널역", "양재역", "매봉역" };
        LineRepository.addLine(addStationToLine(stations, lineNo3));
    }

    private void setLineShinBundang(Line lineShinBundang) {
        String[] stations = { "강남역", "양재역", "양재시민의숲역" };
        LineRepository.addLine(addStationToLine(stations, lineShinBundang));
    }

    private Line addStationToLine(String[] stations, Line line) {
        for (String station : stations) {
            line.addStation(new Station(station));
        }
        return line;
    }
}
