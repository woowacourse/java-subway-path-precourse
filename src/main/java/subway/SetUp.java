package subway;

import subway.domain.Station;
import subway.domain.StationRepository;

/**
 * @author yhh1056
 * @since 2020/12/19
 */
public class SetUp {
    private static final String GYODAE = "교대역";
    private static final String GANGNAM = "강남역";
    private static final String YEOKSAM = "역삼역";
    private static final String NAMBU_TERMINAL = "남부터미널역";
    private static final String YANGJAE = "양재역";
    private static final String YANGJAE_CITIZEN_FOREST = "양재시민의숲역";
    private static final String MAEBONG = "매봉역";

    public static void setUp() {
        setUpStation();
    }

    public static void setUpStation() {
        StationRepository.addStation(new Station(GYODAE));
        StationRepository.addStation(new Station(GANGNAM));
        StationRepository.addStation(new Station(YEOKSAM));
        StationRepository.addStation(new Station(NAMBU_TERMINAL));
        StationRepository.addStation(new Station(YANGJAE));
        StationRepository.addStation(new Station(YANGJAE_CITIZEN_FOREST));
        StationRepository.addStation(new Station(MAEBONG));
    }
}
