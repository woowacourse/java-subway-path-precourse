package subway.view.pathview;

import subway.domain.SectionService;
import subway.model.ResultDto;
import subway.view.OutputView;

public class ShortestPathView extends SearchPathView {

    @Override
    protected void requestSearchPath(String startStation, String endStation) {
        ResultDto result = SectionService.findShortestPath(startStation, endStation);
        OutputView.printResult(result);
    }

    @Override
    public String getName() {
        return "최단 거리";
    }
}
