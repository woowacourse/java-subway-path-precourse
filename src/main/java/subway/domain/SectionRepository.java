package subway.domain;

import java.util.*;

public class SectionRepository {
    private static final Map<Line, List<Section>> sectionMap = new HashMap<>();

    static {
        sectionMap.put(LineRepository.getLine("2호선"), new ArrayList<>(Arrays.asList(
                new Section(StationRepository.getStation("교대역"), StationRepository.getStation("강남역"), 2, 3),
                new Section(StationRepository.getStation("강남역"), StationRepository.getStation("역삼역"), 2, 3)
        )));

        sectionMap.put(LineRepository.getLine("3호선"), new ArrayList<>(Arrays.asList(
                new Section(StationRepository.getStation("교대역"), StationRepository.getStation("남부터미널역"), 3, 2),
                new Section(StationRepository.getStation("남부터미널역"), StationRepository.getStation("양재역"), 6, 5),
                new Section(StationRepository.getStation("양재역"), StationRepository.getStation("매봉역"), 1, 1)
        )));

        sectionMap.put(LineRepository.getLine("신분당선"), new ArrayList<>(Arrays.asList(
                new Section(StationRepository.getStation("강남역"), StationRepository.getStation("양재역"), 2, 8),
                new Section(StationRepository.getStation("양재역"), StationRepository.getStation("양재시민의숲역"), 10, 3)
        )));
    }

    public static List<Section> getAllSections() {
        List<Section> allSections = new ArrayList<>();
        sectionMap.values().forEach(allSections::addAll);
        return Collections.unmodifiableList(allSections);
    }
}