package subway.util.constants;

public enum StationName implements EnumUtil<String, String>{
    GYODAE("교대역"),
    GANGNAM("강남역"),
    YEOKSAM("역삼역"),
    SOUTH_TERMINAL("남부터미널역"),
    MAEBONG("매봉역"),
    YANGJAE("양재역"),
    YANGJAE_CITIZEN_FOREST("양재시민의숲역"),
    STATION_SUFFIX("역");

    private String stationName;

    StationName(String stationName){
        this.stationName = stationName;
    }


    @Override
    public String getKey() {
        return stationName;
    }

    @Override
    public String getValue() {
        return name();
    }
}
