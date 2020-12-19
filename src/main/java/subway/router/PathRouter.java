package subway.router;

import subway.router.menu.PathMenu;

public class PathRouter {

    public static void run() {
        PathMenu.initMenuStatus();
        PathMenu.printMenu();
    }
}
