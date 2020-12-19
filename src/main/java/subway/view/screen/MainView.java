package subway.view.screen;

import subway.view.OutputView;
import subway.view.Prefix;

public class MainView {
    private static final String MAIN = Prefix.SHARP.getPrefix() + "메인 화면";
    private static final String SEARCH = Prefix.ONE.getPrefix() + "경로 조회";
    private static final String QUIT = Prefix.QUIT.getPrefix() + "종료";
    private final OutputView outputView;

    public MainView(OutputView outputView) {
        this.outputView = outputView;
    }

    public void showOptions() {
        outputView.printOptions(new String[]{MAIN, SEARCH, QUIT});
    }
}
