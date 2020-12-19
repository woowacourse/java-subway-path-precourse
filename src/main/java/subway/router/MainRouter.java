package subway.router;

import subway.exception.SubwayMapException;
import subway.router.menu.MainMenu;
import subway.view.InputView;
import subway.view.OutputView;

public class MainRouter {

    private MainRouter() {}

    public static void run() {
        do {
            MainMenu.printMenu();
            MainRouter.Choose().execute();
        } while (MainMenu.isRestart());

    }

    private static MainMenu Choose() {
        try {
            return MainMenu.getMainMenuType(InputView.print(InputView.PLEASE_SELECT_FUNCTION));
        } catch (SubwayMapException e) {
            OutputView.printNewLine();
            OutputView.print(e.getMessage());
            return Choose();
        }
    }
}
