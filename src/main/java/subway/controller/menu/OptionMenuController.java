package subway.controller.menu;

import subway.controller.path.QuickestPathController;
import subway.controller.path.ShortestPathController;
import subway.view.InputView;
import subway.view.OutputView;

public class OptionMenuController extends MenuController {

    public OptionMenuController(InputView inputView) {
        super(inputView);
        childControllers.add(new ShortestPathController(inputView));
        childControllers.add(new QuickestPathController(inputView));
    }

    @Override
    protected void printMenu() {
        OutputView.printOptionMenu();
    }
}
