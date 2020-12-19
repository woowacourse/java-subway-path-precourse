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
                PathChoice pathChoice = PathChoice.of(InputView.inputString());
                if (pathChoice == PathChoice.BACK) {
                    return;
                }
                /** TODO: 최단 거리, 최소 시간 뷰로 이동 기능 구현  */
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
