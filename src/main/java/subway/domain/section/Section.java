package subway.domain.section;

import subway.domain.station.Station;

import java.util.*;
import java.util.stream.IntStream;

public class Section {
    List<Station> sections;
    Map<StationPair, Integer> distance = new HashMap<>();
    Map<StationPair, Integer> time = new HashMap<>();

    public Section(List<Station> sections, List<DistanceAndTime> distanceAndTimes) {
        this.sections = sections;
        setDistanceAndTime(distanceAndTimes);
    }

    private void setDistanceAndTime(List<DistanceAndTime> distanceAndTime) {
        IntStream.range(0, sections.size()-1).forEach(index -> {
            setDistance(sections.get(index), sections.get(index+1), distanceAndTime.get(index));
            setTime(sections.get(index), sections.get(index+1), distanceAndTime.get(index));
        });
    }

    private void setDistance(Station from, Station to, Distance distance) {
        this.distance.put(new StationPair(from, to), distance.getDistance());
        this.distance.put(new StationPair(to, from), distance.getDistance());
    }

    private void setTime(Station from, Station to, Time time) {
        this.time.put(new StationPair(from, to), time.getTime());
        this.time.put(new StationPair(to, from), time.getTime());
    }
}
