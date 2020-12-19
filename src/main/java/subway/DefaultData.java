package subway;

import subway.domain.*;

public class DefaultData {
    public static void setting() {
        station();
        line();
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
}
