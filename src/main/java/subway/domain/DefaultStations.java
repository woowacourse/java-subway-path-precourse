package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DefaultStations {

    public static final String GYODAE = "교대역";
    public static final String GANGNAM = "강남역";
    public static final String YEOKSAM = "역삼역";
    public static final String NAMBUBUS = "남부터미널역";
    public static final String YANGJAE = "양재역";
    public static final String YANGJAE_CITIZENS_FOREST = "양재시민의숲역";
    public static final String MAEBONG = "매봉역";
    private static List<Station> defaultStations = new ArrayList<>();

    public DefaultStations() {
        defaultStations.add(new Station(GYODAE));
        defaultStations.add(new Station(GANGNAM));
        defaultStations.add(new Station(YEOKSAM));
        defaultStations.add(new Station(NAMBUBUS));
        defaultStations.add(new Station(YANGJAE));
        defaultStations.add(new Station(YANGJAE_CITIZENS_FOREST));
        defaultStations.add(new Station(MAEBONG));
    }

    public static List<Station> getDefaultStations() {
        return Collections.unmodifiableList(defaultStations);
    }

    public static List<String> getDefaultNames() {
        List<String> defaultNames = new ArrayList<>();
        for (Station station : defaultStations) {
            defaultNames.add(station.getName());
        }
        return defaultNames;
    }
}
