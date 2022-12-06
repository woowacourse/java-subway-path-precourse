package subway.domain.section;

import subway.domain.line.Line;
import subway.domain.station.Station;
import subway.domain.util.MessageFactory;

import java.util.LinkedList;

import static subway.domain.util.InfoCode.*;

public class LineSection {
    private Line line;
    private LinkedList<Station> stations;

    public LineSection(Line line, LinkedList<Station> stations) {
        this.line = line;
        this.stations = stations;
    }

    public String getLineName() {
        return line.getName();
    }

    public boolean lineEquals(Line inputLine) {
        return line.equals(inputLine);
    }

    public boolean containsStation(Station station) {
        return stations.contains(station);

    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        MessageFactory messageFactory = new MessageFactory();
        stringBuilder.append(messageFactory.makeInfo(line.getName()));
        stringBuilder.append(messageFactory.makeInfoMessage(LINE));
        for (Station station : stations)
            stringBuilder.append(messageFactory.makeInfo(station.getName()));
        stringBuilder.append(BLANK_LINE.getMessage());
        return stringBuilder.toString();
    }

}
