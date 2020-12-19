package subway;

import java.util.Scanner;
import subway.utils.MainScreen;
import subway.utils.PathSearchScreen;
import subway.view.InputView;
import subway.view.OutputView;

public class Router {
    private static final String MAIN_SCREEN = "MAIN_SCREEN";
    private static final String PATH_SEARCH_SCREEN = "PATH_SEARCH_SCREEN";
    private static final Boolean BACK_TO_MAIN_SCREEN = true;

    private static InputView inputView;

    public Router(Scanner scanner) {
        this.inputView = new InputView(scanner);
    }

    public void run() {
        String command;
        do {
            command = inputView.getScreenCommand(MAIN_SCREEN, OutputView.MAIN_SCREEN);
        } while (routeMainScreen(command));
    }

    private boolean routeMainScreen(String command) {
        return MainScreen.run(command);
    }

    public static Boolean enterPathSearchScreen() {
        String command = inputView.getScreenCommand(PATH_SEARCH_SCREEN
            , OutputView.PATH_SEARCH_SCREEN);

        if (routePathSearchScreen(command)) {
            return enterPathSearchScreen();
        }
        return BACK_TO_MAIN_SCREEN;
    }

    private static boolean routePathSearchScreen(String command) {
        return PathSearchScreen.run(inputView, command);
    }
}
