package subway.domain;

public enum StationInfo {
    GYOBYEON_STATION("교대역"),
    GANGNAM_STATION("강남역"),
    YEOKSAM_STATION("역삼역"),
    NAMBU_TERMINAL_STATION("남부터미널역"),
    YANGJAE_STATION("양재역"),
    YANGJAE_CITIZEN_FOREST_STATION("양재시민의숲역"),
    MAEBONG_STATIO("매봉역");

    private final String name;

    StationInfo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
