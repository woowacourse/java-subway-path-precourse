package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class SectionRepository {

    private static final List<Section> sections = new ArrayList<>();

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
        for (int i = 1; i < shortestPath.size(); i++){
            totalMinute = getTimeBySection(shortestPath.get(i-1), shortestPath.get(i));
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
