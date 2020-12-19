package subway.initializer;

import subway.service.LineService;
import subway.service.PathService;
import subway.service.StationService;

import java.util.Arrays;

public class AppInitializer {
    private static final StationService stationService = new StationService();
    private static final LineService lineService = new LineService();
    private static final PathService pathService = new PathService();

    public static void run() {
        final String 교대역 = "교대역";
        final String 강남역 = "강남역";
        final String 역삼역 = "역삼역";
        final String 남부터미널역 = "남부터미널역";
        final String 양재역 = "양재역";
        final String 양재시민의숲역 = "양재시민의숲역";
        final String 매봉역 = "매봉역";

        stationService.addStation(교대역);
        stationService.addStation(강남역);
        stationService.addStation(역삼역);
        stationService.addStation(남부터미널역);
        stationService.addStation(양재역);
        stationService.addStation(양재시민의숲역);
        stationService.addStation(매봉역);

        lineService.addLine("2호선", Arrays.asList(교대역, 강남역, 역삼역));
        lineService.addLine("3호선", Arrays.asList(교대역, 남부터미널역, 양재역, 매봉역));
        lineService.addLine("신분당선", Arrays.asList(강남역, 양재역, 양재시민의숲역));

        pathService.addPath(교대역, 강남역, 2, 3);
        pathService.addPath(강남역, 역삼역, 2, 3);

        pathService.addPath(교대역, 남부터미널역, 3, 2);
        pathService.addPath(남부터미널역, 양재역, 6, 5);
        pathService.addPath(양재역, 매봉역, 1, 1);


        pathService.addPath(강남역, 양재역, 2, 8);
        pathService.addPath(양재역, 양재시민의숲역, 10, 3);
    }
}
