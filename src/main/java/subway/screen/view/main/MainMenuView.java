package subway.screen.view.main;

import subway.presentation.MainViewController;
import subway.screen.view.Menu;
import subway.screen.view.MenuEventManager;
import subway.screen.view.MenuView;

public class MainMenuView extends MenuView {
    public MainMenuView(MainViewController mainViewController) {
        super(MenuEventManager.builder()
            .addEventListener(MainMenu.PATH_SEARCH, mainViewController::handlePathSearch)
            .addEventListener(MainMenu.END, mainViewController::handleEnd));
    }

    @Override
    public String title() {
        return "메인 화면";
    }

    @Override
    protected Class<? extends Menu> getType() {
        return MainMenu.class;
    }
}
