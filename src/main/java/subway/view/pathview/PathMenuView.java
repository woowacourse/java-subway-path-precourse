package subway.view.pathview;

import subway.view.InputView;
import subway.view.OutputView;
import subway.view.View;

public class PathMenuView implements View {

    private final String name = "경로 기준";

    @Override
    public void setVisible() {
        while (true) {
            try {
                OutputView.println(VIEW_PREFIX + name);
                OutputView.printPathMenuInputGuideMessage();
                PathChoice choice = PathChoice.of(InputView.inputString());
                if (choice == PathChoice.BACK) {
                    return;
                }
                choice.visitView();
                return;
            } catch (RuntimeException e) {
                OutputView.printExceptionMessage(e);
            }
        }
    }

    @Override
    public String getName() {
        return null;
    }
}
