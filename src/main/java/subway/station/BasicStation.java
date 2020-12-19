package subway.station;

public enum BasicStation {
    GYODAE("교대역"),
    GANGNAM("강남역"),
    YEOKSAM("역삼역"),
    NAMBUTERMINAL("남부터미널역"),
    YANGJAE("양재역"),
    YANGJAECITIZEN("양재시민의숲역"),
    MAEBONG("매봉역");

    private String name;

    BasicStation(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
