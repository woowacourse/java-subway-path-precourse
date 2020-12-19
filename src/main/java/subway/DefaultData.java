package subway;

import subway.domain.*;

import java.util.ArrayList;
import java.util.List;

public class DefaultData {
    public static void setting() {
        station();
        line();
        section();
    }

    public static void station() {
        Constant.defaultStationList().forEach(station -> {
            StationRepository.addStation(new Station(station));
        });
    }

    public static void line() {
        for (int i = 0; i < Constant.defaultLineList().size(); i++) {
            Line line = new Line(Constant.defaultLineList().get(i));
            for (int j = 0; j < Constant.defaultSettingList().get(i).length; j++) {
                addStationToLine(line, Constant.defaultSettingList().get(i)[j]);
            }
            LineRepository.addLine(line);
        }
    }

    public static void addStationToLine(Line line, String stationName) {
        StationRepository.stations().forEach(station -> {
            if (station.getName().equals(stationName)) {
                line.addStation(station);
            }
        });
    }

    public static void section() {
        List<Line> lines = LineRepository.lines();
        for (int i = 0; i < lines.size(); i++){
            for (int j = 0; j < lines.get(i).stations().size() - 1; j++){
                List<Station> stations = new ArrayList<>();
                stations.add(lines.get(i).stations().get(j));
                stations.add(lines.get(i).stations().get(j + 1));
                Section section = new Section(stations, Constant.defaultTime[i][j], Constant.defaultDistance[i][j]);
                SectionRepository.addSection(section);
            }
        }
    }
}
