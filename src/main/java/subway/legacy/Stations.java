package subway.legacy;

public enum Stations {

    GYODAE("교대역"),
    GANGNAM("강남역"),
    YEOKSAM("역삼역"),
    NAMBU_BUS_TERMINAL("남부터미널역"),
    YANGJAE("양재역"),
    YANGJAE_CITIZEN_FOREST("양재시민의숲역"),
    MAEBONG("매봉역");

    private String name;
    Stations(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
