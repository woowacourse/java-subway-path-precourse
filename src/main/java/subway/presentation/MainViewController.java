package subway.presentation;

import subway.screen.ui.Console;
import subway.screen.view.Menu;
import subway.screen.view.main.MainMenuView;

public class MainViewController implements ViewController {
    private final MainMenuView mainMenuView = new MainMenuView(this);

    private boolean end;

    @Override
    public void execute() {
        this.end = false;
        do {
            mainMenuView.show();
            Menu menu = mainMenuView.question();
            try {
                mainMenuView.onEvent(menu);
            } catch (IllegalArgumentException e) {
                Console.printError(e.getMessage());
                Console.println();
            }
        } while (!this.end);
    }

    public void handlePathSearch() {
        PathViewController pathViewController = new PathViewController();
        pathViewController.execute();
    }

    public void handleEnd() {
        this.end = true;
    }
}
