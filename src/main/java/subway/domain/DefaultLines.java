package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class DefaultLines {

    private static final String LINE_TWO = "2호선";
    private static final String LINE_THREE = "3호선";
    private static final String LINE_SINBUNDANG = "신분당선";
    private static List<Line> defaultLines = new ArrayList<Line>();

    public static void initializeDefaultLines() {
        Line lineTwo = initializeLineTwo();
        Line lineThree = initializeLineThree();
        Line lineSinbundang = initializeLineSinbundang();
        defaultLines.add(lineTwo);
        defaultLines.add(lineThree);
        defaultLines.add(lineSinbundang);
    }

    private static Line initializeLineTwo() {
        Line lineTwo = new Line(LINE_TWO);
        lineTwo.addStation(new Station(DefaultStations.GYODAE))
            .addStation(new Station(DefaultStations.GANGNAM))
            .addStation(new Station(DefaultStations.YEOKSAM));
        return lineTwo;
    }

    private static Line initializeLineThree() {
        Line lineThree = new Line(LINE_THREE);
        lineThree.addStation(new Station(DefaultStations.GYODAE))
            .addStation(new Station(DefaultStations.NAMBUBUS))
            .addStation(new Station(DefaultStations.YANGJAE))
            .addStation(new Station(DefaultStations.MAEBONG));
        return lineThree;
    }

    private static Line initializeLineSinbundang() {
        Line lineSinbundang = new Line(LINE_SINBUNDANG);
        lineSinbundang.addStation(new Station(DefaultStations.GANGNAM))
            .addStation(new Station(DefaultStations.YANGJAE))
            .addStation(new Station(DefaultStations.YANGJAE_CITIZENS_FOREST));
        return lineSinbundang;
    }

    public static List<Line> getDefaultLines() {
        return defaultLines;
    }
}
