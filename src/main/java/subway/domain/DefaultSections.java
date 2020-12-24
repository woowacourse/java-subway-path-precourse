package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class DefaultSections {

    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FIVE = 5;
    private static final int SIX = 6;
    private static final int EIGHT = 8;
    private static final int TEN = 10;

    private static List<Section> sections;

    public DefaultSections() {
        sections = new ArrayList<>();
        initializeDefaultSections();
    }

    public static void initializeDefaultSections() {
        initLineTwoSections();
        initLineThreeSections();
        initLineSinbundangSections();
    }

    public static void initLineSinbundangSections() {
        sections.add(
            new Section(DefaultStations.GANGNAM, DefaultStations.YANGJAE, new Cost(TWO, EIGHT)));
        sections.add(new Section(DefaultStations.YANGJAE, DefaultStations.YANGJAE_CITIZENS_FOREST,
            new Cost(TEN, THREE)));
    }

    public static void initLineThreeSections() {
        sections.add(
            new Section(DefaultStations.GYODAE, DefaultStations.NAMBUBUS, new Cost(THREE, TWO)));
        sections.add(
            new Section(DefaultStations.NAMBUBUS, DefaultStations.YANGJAE, new Cost(SIX, FIVE)));
        sections.add(
            new Section(DefaultStations.YANGJAE, DefaultStations.MAEBONG, new Cost(ONE, ONE)));
    }

    public static void initLineTwoSections() {
        sections.add(
            new Section(DefaultStations.GYODAE, DefaultStations.GANGNAM, new Cost(TWO, THREE)));
        sections.add(
            new Section(DefaultStations.GANGNAM, DefaultStations.YEOKSAM, new Cost(TWO, THREE)));
    }

    public static List<Section> getSections() {
        return sections;
    }

    public static Cost getSectionCost(String departureStation, String arrivalStation) {
        for (Section section : sections) {
            if (section.isSameSection(departureStation, arrivalStation)) {
                return section.getCost();
            }
        }
        throw new IllegalArgumentException();
    }
}
