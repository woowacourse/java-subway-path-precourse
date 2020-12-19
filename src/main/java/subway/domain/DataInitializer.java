package subway.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class DataInitializer {

    public static void initialize() {
        initializeStations();
        initializeLines();
        initializeSections();
        initializeTimeGraph();
    }

    private static void initializeStations() {
        StationRepository.addStation(new Station("교대역"));
        StationRepository.addStation(new Station("강남역"));
        StationRepository.addStation(new Station("역삼역"));
        StationRepository.addStation(new Station("남부터미널역"));
        StationRepository.addStation(new Station("매봉역"));
        StationRepository.addStation(new Station("양재역"));
        StationRepository.addStation(new Station("양재시민의숲역"));
    }

    private static void initializeLines() {
        LineRepository.addLine(new Line("2호선", Arrays.asList(
                StationRepository.searchByName("교대역"),
                StationRepository.searchByName("강남역"),
                StationRepository.searchByName("역삼역")
        )));
        LineRepository.addLine(new Line("3호선", Arrays.asList(
                StationRepository.searchByName("교대역"),
                StationRepository.searchByName("남부터미널역"),
                StationRepository.searchByName("양재역"),
                StationRepository.searchByName("매봉역")
        )));
        LineRepository.addLine(new Line("신분당선", Arrays.asList(
                StationRepository.searchByName("강남역"),
                StationRepository.searchByName("양재역"),
                StationRepository.searchByName("양재시민의숲역")
        )));
    }

    public static void initializeSections() {
        initializeLine2Sections();
        initializeLine3Sections();
        initilizeShinbundangLine();
    }

    private static void initializeLine2Sections() {
        Section section;
        section = new Section(new HashSet<Station>(Arrays.asList(
                StationRepository.searchByName("교대역"),
                StationRepository.searchByName("강남역")
        )), 3, 2);
        SectionRepository.addSection(section);

        section = new Section(new HashSet<Station>(Arrays.asList(
                StationRepository.searchByName("강남역"),
                StationRepository.searchByName("역삼역")
        )), 3, 2);
        SectionRepository.addSection(section);
    }

    private static void initializeLine3Sections() {
        Section section;
        section = new Section(new HashSet<Station>(Arrays.asList(
                StationRepository.searchByName("교대역"),
                StationRepository.searchByName("남부터미널역")
        )), 3, 2);
        SectionRepository.addSection(section);

        section = new Section(new HashSet<Station>(Arrays.asList(
                StationRepository.searchByName("남부터미널역"),
                StationRepository.searchByName("양재역")
        )), 6, 5);
        SectionRepository.addSection(section);

        section = new Section(new HashSet<Station>(Arrays.asList(
                StationRepository.searchByName("양재역"),
                StationRepository.searchByName("매봉역")
        )), 1, 1);
        SectionRepository.addSection(section);
    }

    private static void initilizeShinbundangLine() {
        Section section;
        section = new Section(new HashSet<Station>(Arrays.asList(
                StationRepository.searchByName("강남역"),
                StationRepository.searchByName("양재역")
        )), 2, 8);
        SectionRepository.addSection(section);

        section = new Section(new HashSet<Station>(Arrays.asList(
                StationRepository.searchByName("양재역"),
                StationRepository.searchByName("양재시민의숲역")
        )), 10, 3);
        SectionRepository.addSection(section);
    }

    private static void initializeTimeGraph() {
        List<Section> sections = SectionRepository.sections();
        for (Section section : sections) {
            TimeGraph.addSectionToGraph(section);
        }
    }
}
