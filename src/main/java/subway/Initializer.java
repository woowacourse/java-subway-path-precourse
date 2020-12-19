package subway;

import subway.domain.DistanceAndTimeBetweenStationsRepository;

public class Initializer {
    private static final String GYODAE_STATION = "교대역";
    private static final String GANGNAM_STATION = "강남역";
    private static final String YEOKSAM_STATION = "역삼역";
    private static final String NAMBU_TERMINAL_STATION = "남부터미널역";
    private static final String YANGJAE_STATION = "양재역";
    private static final String YANGJAE_CITIZENS_FOREST_STATION = "양재시민의숲역";
    private static final String MAEBONG_STATION = "매봉역";

    public static void initialize() {
        mapStations();
    }

    private static void mapStations() {
        DistanceAndTimeBetweenStationsRepository
            .addStations(GYODAE_STATION, GANGNAM_STATION, 2, 3);
        DistanceAndTimeBetweenStationsRepository
            .addStations(GANGNAM_STATION, YEOKSAM_STATION, 2, 3);
        DistanceAndTimeBetweenStationsRepository
            .addStations(GYODAE_STATION, NAMBU_TERMINAL_STATION, 3, 2);
        DistanceAndTimeBetweenStationsRepository
            .addStations(NAMBU_TERMINAL_STATION, YANGJAE_STATION, 6, 5);
        DistanceAndTimeBetweenStationsRepository
            .addStations(YANGJAE_STATION, MAEBONG_STATION, 1, 1);
        DistanceAndTimeBetweenStationsRepository
            .addStations(GANGNAM_STATION, YANGJAE_STATION, 2, 8);
        DistanceAndTimeBetweenStationsRepository
            .addStations(YANGJAE_STATION, YANGJAE_CITIZENS_FOREST_STATION, 10, 3);
    }
}
