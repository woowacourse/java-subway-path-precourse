package subway.domain.util;

public class SetupConstant {
    // 역 사전 설정
    public static final String STATION_GYODAE = "교대역";
    public static final String STATION_GANGNAM = "강남역";
    public static final String STATION_YEOKSAM = "역삼역";
    public static final String STATION_NAMBU_TERMINAL = "남부터미널역";
    public static final String STATION_YANGJAE = "양재역";
    public static final String STATION_YANGJAE_CITIZENS_FOREST = "양재시민의숲역";
    public static final String STATION_MAEBONG = "매봉역";

    // 노선 사전 설정
    public static final String LINE_2 = "2호선";
    public static final String LINE_3 = "3호선";
    public static final String LINE_SINBUNDANG = "신분당선";

    // 소요 거리 사전 설정
    public static final int DIST_GYODAE_TO_GANGNAM = 2;
    public static final int DIST_GANGNAM_TO_YEOKSAM = 2;
    public static final int DIST_GYODAE_TO_NAMBU_TERMINAL = 3;
    public static final int DIST_NAMBU_TERMINAL_TO_YANGJAE = 6;
    public static final int DIST_YANGJAE_TO_MAEBONG = 1;
    public static final int DIST_GANGNAM_TO_YANGJAE = 2;
    public static final int DIST_YANGJAE_TO_YANGJAE_CITIZEN_FOREST = 10;

    // 소요 시간 사전 설정
    public static final int TIME_GYODAE_TO_GANGNAM = 3;
    public static final int TIME_GANGNAM_TO_YEOKSAM = 3;
    public static final int TIME_GYODAE_TO_NAMBU_TERMINAL = 2;
    public static final int TIME_NAMBU_TERMINAL_TO_YANGJAE = 5;
    public static final int TIME_YANGJAE_TO_MAEBONG = 1;
    public static final int TIME_GANGNAM_TO_YANGJAE = 8;
    public static final int TIME_YANGJAE_TO_YANGJAE_CITIZEN_FOREST = 3;
}
