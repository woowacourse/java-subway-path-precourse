package subway.domain;

public class LineUtils {

    private LineUtils() {}

    public static final StationRepository STATION_REPOSITORY =
            new StationRepository().addStations("봉천역", "신림역", "신대방역");

    public static final Distances DISTANCES = new Distances(1, 2);

    public static final ElapsedTimes ELAPSED_TIMES = new ElapsedTimes(5, 10);

    public static final LineDirection LINE_DIRECTION = new LineDirection(STATION_REPOSITORY,
            DISTANCES, ELAPSED_TIMES);

    public static Line getTestInstance() {
        return new Line("2호선", LINE_DIRECTION);
    }
}
