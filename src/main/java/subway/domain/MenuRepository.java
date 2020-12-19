package subway.domain;

import subway.menu.mainmenu.MainMenu;
import subway.menu.mainmenu.QuitMenu;
import subway.menu.mainmenu.SearchPathMenu;

import java.util.*;

public class MenuRepository {
    public static final List<String> mainMenuButtons = new ArrayList<>(Arrays.asList(SearchPathMenu.MENU_BUTTON, QuitMenu.MENU_BUTTON));
//    public static final List<String> searchMenuButtons;

    public static final Map<String, MainMenu> mainMenu = new HashMap<>();

    static {
        mainMenu.put(SearchPathMenu.MENU_BUTTON, new SearchPathMenu());
    }

}
