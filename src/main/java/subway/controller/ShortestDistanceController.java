package subway.controller;

import subway.domain.ShortestDistanceDto;
import subway.service.PathService;
import subway.service.SectionService;
import subway.util.InputUtils;
import subway.util.PrintUtils;

public class ShortestDistanceController implements Controller {

    private final static String TITLE = "최단 거리";

    private static final String FROM_STATION_DESCRIPTION = "출발역을 입력하세요.";
    private static final String TO_STATION_DESCRIPTION = "도착역을 입력하세요.";

    @Override
    public void run(InputUtils inputUtils) {
        PrintUtils.printTitleOrDescription(FROM_STATION_DESCRIPTION);
        String fromStationName = inputUtils.getNextLine();
        PrintUtils.printTitleOrDescription(TO_STATION_DESCRIPTION);
        String toStationName = inputUtils.getNextLine();

        ShortestDistanceDto shortestDistancePath = PathService
            .getShortestDistancePath(fromStationName, toStationName);

        if (shortestDistancePath != null) {
            int totalTime = SectionService.getTotalTime(shortestDistancePath.getStationList());
            PrintUtils.printShortestPath(shortestDistancePath.getTotalDistance(), totalTime,
                shortestDistancePath.getStationList());
        }

    }

    @Override
    public String getTitle() {
        return TITLE;
    }
}
