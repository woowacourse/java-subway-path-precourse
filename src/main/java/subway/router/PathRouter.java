package subway.router;

import subway.controller.PathController;
import subway.exception.SubwayMapException;
import subway.router.menu.PathMenu;
import subway.view.InputView;
import subway.view.OutputView;

public class PathRouter {

    public static void run() {
        do {
            PathMenu.initMenuStatus();
            PathMenu.printMenu();
            choose().execute(PathController.getInstance());
        } while (PathMenu.isRestart());
    }

    private static PathMenu choose() {
        try {
            return PathMenu.getMainMenuType(InputView.print(InputView.PLEASE_SELECT_FUNCTION));
        } catch (SubwayMapException e) {
            OutputView.printNewLine();
            OutputView.print(e.getMessage());
            return choose();
        }
    }
}
