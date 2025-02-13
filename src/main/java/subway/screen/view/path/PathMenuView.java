package subway.screen.view.path;

import subway.presentation.PathViewController;
import subway.screen.view.Menu;
import subway.screen.view.MenuEventManager;
import subway.screen.view.MenuView;

public class PathMenuView extends MenuView {
    public PathMenuView(PathViewController pathViewController) {
        super(MenuEventManager.builder()
            .addEventListener(PathMenu.SHORT_DISTANCE, pathViewController::handleShortDistance)
            .addEventListener(PathMenu.SHORT_TIME, pathViewController::handleShortTime)
            .addEventListener(PathMenu.BACK));
    }

    @Override
    public String title() {
        return "경로 기준";
    }

    @Override
    protected Class<? extends Menu> getType() {
        return PathMenu.class;
    }
}
