package subway.controller;

import subway.domain.ShortestTimeDto;
import subway.service.PathService;
import subway.service.SectionService;
import subway.util.InputUtils;
import subway.util.PrintUtils;

public class ShortestTimeController implements Controller {

    private final static String TITLE = "최소 시간";

    private static final String FROM_STATION_DESCRIPTION = "출발역을 입력하세요.";
    private static final String TO_STATION_DESCRIPTION = "도착역을 입력하세요.";

    @Override
    public void run(InputUtils inputUtils) {
        PrintUtils.printTitleOrDescription(FROM_STATION_DESCRIPTION);
        String fromStationName = inputUtils.getNextLine();
        PrintUtils.printTitleOrDescription(TO_STATION_DESCRIPTION);
        String toStationName = inputUtils.getNextLine();

        ShortestTimeDto shortestTimePath = PathService
            .getShortestTimePath(fromStationName, toStationName);

        if (shortestTimePath != null) {
            int totalDistance = SectionService.getTotalDistance(shortestTimePath.getStationList());
            PrintUtils.printShortestPath(totalDistance, shortestTimePath.getTotalTime(),
                shortestTimePath.getStationList());
        }

    }

    @Override
    public String getTitle() {
        return TITLE;
    }
}
