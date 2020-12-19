package subway;

import java.util.Scanner;
import subway.screen.MainScreen;
import subway.screen.Screen;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayPath {

    private static Screen screen = MainScreen.ROUTE;
    private InputView inputView ;

    public SubwayPath(Scanner scanner) {
        InputView.initScanner(scanner);
        this.inputView = InputView.getInstance();
    }

    public void run() {

        while (screen != null){
            selectCommandAndRun();

        }

    }

    private void selectCommandAndRun() {

        try {
            OutputView.printMenus(screen);
            String command = inputView.inputCommand();
            this.screen = screen.getValue(command);
            this.screen = screen.run();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
        }
    }

}
