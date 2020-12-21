package subway.domain;

import java.util.LinkedList;

public class Line {
    private static LinkedList<Station> line = new LinkedList<>();
    private String name;

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addSection(int sequence, Station station) {
        line.add(sequence, station);
    }

    public Line addTerminus(String upBoundTerminus, String downBoundTerminus) {
        line.addFirst(StationRepository.findStation(upBoundTerminus));
        line.addLast(StationRepository.findStation(downBoundTerminus));
        return this;
    }
}
