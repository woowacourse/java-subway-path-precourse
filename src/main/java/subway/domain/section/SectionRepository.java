package subway.domain.section;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import subway.domain.station.Station;

public class SectionRepository {

    private static final List<Section> sections = new ArrayList<>();

    static {
        sections.add(new Section(2, 3, Arrays.asList(
            new Station("교대역"),
            new Station("강남역")
        )));
        sections.add(new Section(2, 3, Arrays.asList(
            new Station("강남역"),
            new Station("역삼역")
        )));
        sections.add(new Section(3, 2, Arrays.asList(
            new Station("교대역"),
            new Station("남부터미널역")
        )));
        sections.add(new Section(6, 5, Arrays.asList(
            new Station("남부터미널역"),
            new Station("양재역")
        )));
        sections.add(new Section(1, 1, Arrays.asList(
            new Station("양재역"),
            new Station("매봉역")
        )));
        sections.add(new Section(2, 8, Arrays.asList(
            new Station("강남역"),
            new Station("양재역")
        )));
        sections.add(new Section(10, 3, Arrays.asList(
            new Station("양재역"),
            new Station("양재시민의숲역")
        )));
    }

    public static Section getSectionByStations(Station station, Station otherStation) {

        return sections.stream()
            .filter(section -> section.isSame(station, otherStation))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("[ERROR] 존재하지 않는 구간입니다."));
    }

    public static int calculateDistanceSum(List<String> namesOfStations) {
        int distanceSum = 0;
        for (int i = 0; i < namesOfStations.size() - 1; i++) {
            distanceSum += getSectionByStations(
                new Station(namesOfStations.get(i)),
                new Station(namesOfStations.get(i + 1))
            ).getDistance();
        }
        return distanceSum;
    }

    public static int calculateTimeSum(List<String> namesOfStations) {
        int timeSum = 0;
        for (int i = 0; i < namesOfStations.size() - 1; i++) {
            timeSum += getSectionByStations(
                new Station(namesOfStations.get(i)),
                new Station(namesOfStations.get(i + 1))
            ).getTime();
        }
        return timeSum;
    }

    public static boolean contains(Station station, Station otherStation) {
        for (Section section : sections) {
            List<Station> stations = section.getStations();
            if (stations.contains(station) && stations.contains(otherStation)) {
                return true;
            }
        }
        return false;
    }
}
