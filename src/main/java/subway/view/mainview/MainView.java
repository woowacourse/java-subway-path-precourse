package subway.view.mainview;

import subway.view.InputView;
import subway.view.OutputView;
import subway.view.View;

public class MainView implements View {

    private final String name = "메인 화면";

    @Override
    public void setVisible() {
        while (true) {
            try {
                OutputView.println(VIEW_PREFIX + name);
                OutputView.printMainMenuInputGuideMessage();
                MainChoice choice = MainChoice.of(InputView.inputString());
                if (choice == MainChoice.EXIT) {
                    return;
                }
                choice.visitView();
            } catch (RuntimeException e) {
                OutputView.printExceptionMessage(e);
            }
        }
    }

    @Override
    public String getName() {
        return this.name;
    }
}
