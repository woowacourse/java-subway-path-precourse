package subway.view.screen;

import subway.view.OutputView;
import subway.view.Prefix;

public class SearchView {
    private static final String MAIN = Prefix.SHARP.getPrefix() + "경로 기준";
    private static final String DISTANCE = Prefix.ONE.getPrefix() + "최단 거리";
    private static final String TIME = Prefix.TWO.getPrefix() + "최소 시간";
    private static final String BACK = Prefix.BACK.getPrefix() + "돌아가기";

    private final OutputView outputView;

    public SearchView(OutputView outputView) {
        this.outputView = outputView;
    }

    public void showOptions() {
        outputView.printOptions(new String[]{MAIN, DISTANCE, TIME, BACK});
    }
}
