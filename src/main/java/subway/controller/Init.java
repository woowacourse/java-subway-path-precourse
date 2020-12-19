package subway.controller;

import java.util.Arrays;
import java.util.List;

public enum Init {
    GYODAE(0, "교대역"), GANGNAM(1, "강남역"), YEOKSAM(2, "역삼역"), SOUTH_TERMINAL(3, "남부터미널역"), YANGJAE(4, "양재역"),
    YANGJAE_FOREST(5, "양재시민의숲역"), MAEBONG(6, "매봉역");

    private int stationNumber;
    private String stationName;
    public static List<Init> initList = Arrays.asList(GYODAE, GANGNAM, YEOKSAM, SOUTH_TERMINAL, YANGJAE, YANGJAE_FOREST,
            MAEBONG);

    private Init(int stationNumber, String stationName) {
        this.stationNumber = stationNumber;
        this.stationName = stationName;
    }

    public int getStaionNumber() {
        return stationNumber;
    }

    public String getStationName() {
        return stationName;
    }

    public static int findStationNumber(String stationName) {
        return initList.stream().filter(item -> item.getStationName().equals(stationName)).findFirst().get()
                .getStaionNumber();
    }

    public static String findStationName(int stationNumber) {
        return initList.stream().filter(item -> item.getStaionNumber() == stationNumber).findFirst().get()
                .getStationName();
    }
}
