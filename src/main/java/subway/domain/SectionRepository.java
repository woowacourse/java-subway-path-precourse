package subway.domain;

import java.util.List;

public class SectionRepository {
    private static final int ONE = 1;

    public static void addSection(Line line, Section section) {
        Line target = LineRepository.findByName(line.getName());
        target.addSection(section);
    }

    public static Sections allSections() {
        List<Line> lines = LineRepository.lines();
        Sections allSections = new Sections();
        for (Line line : lines) {
            allSections.addAll(line.getSections().getUnmodifiableList());
        }
        return allSections;
    }

    public static Section findByName(String from, String to) {
        return allSections().findByName(from, to);
    }

    public static int calculateTotalDistance(List<Station> stations) {
        int totalDistance = 0;
        for (int i = ONE; i < stations.size(); i++) {
            String from = stations.get(i - ONE).getName();
            String to = stations.get(i).getName();
            totalDistance += SectionRepository.findByName(from, to).getDistance();
        }
        return totalDistance;
    }

    public static int calculateTakenTime(List<Station> stations) {
        int totalTime = 0;
        for (int i = ONE; i < stations.size(); i++) {
            String from = stations.get(i - ONE).getName();
            String to = stations.get(i).getName();
            totalTime += SectionRepository.findByName(from, to).getTakenTime();
        }
        return totalTime;
    }
}
