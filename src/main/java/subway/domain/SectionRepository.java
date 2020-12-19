package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import subway.service.LineService;
import subway.service.StationService;

public class SectionRepository {

    private SectionRepository(){
    }

    private static final List<Section> sections = new ArrayList<>();

    public static void initSectionRepository() {
        addSection(Section.newSection(
            LineService.findLineByName("2호선"),
            StationService.findStationByName("교대역"),
            StationService.findStationByName("강남역"),
            Distance.newDistance(2),
            Time.newTime(3)));

        addSection(Section.newSection(
            LineService.findLineByName("2호선"),
            StationService.findStationByName("강남역"),
            StationService.findStationByName("역삼역"),
            Distance.newDistance(2),
            Time.newTime(3)));

        addSection(Section.newSection(
            LineService.findLineByName("3호선"),
            StationService.findStationByName("교대역"),
            StationService.findStationByName("남부터미널역"),
            Distance.newDistance(3),
            Time.newTime(2)));

        addSection(Section.newSection(
            LineService.findLineByName("3호선"),
            StationService.findStationByName("남부터미널역"),
            StationService.findStationByName("양재역"),
            Distance.newDistance(6),
            Time.newTime(5)));

        addSection(Section.newSection(
            LineService.findLineByName("3호선"),
            StationService.findStationByName("양재역"),
            StationService.findStationByName("매봉역"),
            Distance.newDistance(1),
            Time.newTime(1)));

        addSection(Section.newSection(
            LineService.findLineByName("신분당선"),
            StationService.findStationByName("강남역"),
            StationService.findStationByName("양재역"),
            Distance.newDistance(2),
            Time.newTime(8)));

        addSection(Section.newSection(
            LineService.findLineByName("신분당선"),
            StationService.findStationByName("양재역"),
            StationService.findStationByName("양재시민의숲역"),
            Distance.newDistance(10),
            Time.newTime(3)));
    }

    public static List<Section> sections() {
        validateEmpty();
        return Collections.unmodifiableList(sections);
    }

    private static void validateEmpty() {
        if(sections.isEmpty()){
            throw new IllegalArgumentException("등록되어 있는 지하철 구간이 없습니다.");
        }
    }

    public static void addSection(Section section) {
        sections.add(section);
    }

    public static Distance getDistance(List<String> shortestPath) {
        int totalKilometer = 0;
        for (int i = 1; i < shortestPath.size(); i++) {
            totalKilometer += getDistanceBySection(shortestPath.get(i - 1), shortestPath.get(i));
        }
        return Distance.newDistance(totalKilometer);
    }

    private static int getDistanceBySection(String source, String destination) {
        Section findSection = sections.stream()
            .filter(section -> section.isSourceDestinationByName(source)).findAny().get();
        findSection.isSourceDestinationByName(destination);
        return findSection.getDistance().getKilometer();
    }

    public static Time getTime(List<String> shortestPath) {
        int totalMinute = 0;
        for (int i = 1; i < shortestPath.size(); i++) {
            totalMinute += getTimeBySection(shortestPath.get(i - 1), shortestPath.get(i));
        }
        return Time.newTime(totalMinute);
    }

    private static int getTimeBySection(String source, String destination) {
        Section findSection = sections.stream()
            .filter(section -> section.isSourceDestinationByName(source)).findAny().get();
        findSection.isSourceDestinationByName(destination);
        return findSection.getTime().getMinute();
    }
}
