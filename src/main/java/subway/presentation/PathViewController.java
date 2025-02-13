package subway.presentation;

import subway.application.section.dto.ShortCostResponse;
import subway.screen.ui.Console;
import subway.screen.view.Menu;
import subway.screen.view.path.PathMenuView;

public class PathViewController implements ViewController {
    private final PathMenuView pathMenuView = new PathMenuView(this);
    private final SectionController sectionController = new SectionController();

    @Override
    public void execute() {
        do {
            pathMenuView.show();
            Menu menu = pathMenuView.question();
            try {
                pathMenuView.onEvent(menu);
                return;
            } catch (IllegalArgumentException e) {
                Console.printError(e.getMessage());
                Console.println();
            }
        } while (true);
    }

    public void handleShortDistance() {
        String sourceName = this.requestSourceName();
        String sinkName = this.requestSinkName();
        ShortCostResponse shortCostResponse = this.sectionController.computeShortDistance(sourceName, sinkName);
        this.printShortCostResponse(shortCostResponse);
    }

    public void handleShortTime() {
        String sourceName = this.requestSourceName();
        String sinkName = this.requestSinkName();
        ShortCostResponse shortCostResponse = this.sectionController.computeShortTime(sourceName, sinkName);
        this.printShortCostResponse(shortCostResponse);
    }

    private String requestSourceName() {
        Console.printHeader("출발역을 입력하세요");
        String sourceName = Console.readline();
        Console.println();
        return sourceName;
    }

    private String requestSinkName() {
        Console.printHeader("도착역을 입력하세요");
        String sinkName = Console.readline();
        Console.println();
        return sinkName;
    }

    private void printShortCostResponse(ShortCostResponse shortCostResponse) {
        Console.printHeader("조회 결과");
        Console.printInfo("---");
        Console.printInfo(String.format("총 거리 : %dkm", shortCostResponse.getTotalDistance()));
        Console.printInfo(String.format("총 소요 시간 : %d분", shortCostResponse.getTotalTime()));
        Console.printInfo("---");
        for (String stationName : shortCostResponse.getStationNameList()) {
            Console.printInfo(stationName);
        }
        Console.println();
    }
}
