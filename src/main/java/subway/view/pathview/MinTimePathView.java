package subway.view.pathview;

import subway.domain.SectionService;
import subway.model.ResultDto;
import subway.view.OutputView;

public class MinTimePathView extends SearchPathView {

    @Override
    protected void requestSearchPath(String startStation, String endStation) {
        ResultDto result = SectionService.findMinTimePath(startStation, endStation);
        OutputView.printResult(result);
    }

    @Override
    public String getName() {
        return "최소 시간";
    }
}
