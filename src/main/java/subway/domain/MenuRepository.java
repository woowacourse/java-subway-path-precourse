package subway.domain;

import subway.menu.mainmenu.MainMenu;
import subway.menu.mainmenu.QuitMenu;
import subway.menu.mainmenu.SearchPathMenu;
import subway.menu.searchmenu.ExitMenu;
import subway.menu.searchmenu.SearchMenu;
import subway.menu.searchmenu.SearchShortestDistanceMenu;
import subway.menu.searchmenu.SearchShortestTimeMenu;

import java.util.*;

public class MenuRepository {
    public static final List<String> mainMenuButtons = new ArrayList<>(Arrays.asList(SearchPathMenu.MENU_BUTTON, QuitMenu.MENU_BUTTON));
    public static final List<String> searchMenuButtons = new ArrayList<>(
            Arrays.asList(SearchShortestDistanceMenu.MENU_BUTTON, SearchShortestTimeMenu.MENU_BUTTON, ExitMenu.MENU_BUTTON));

    public static final List<String> mainMenuNames = new ArrayList<>(Arrays.asList(SearchPathMenu.MENU_NAME, QuitMenu.MENU_NAME));
    public static final List<String> searchMenuNames = new ArrayList<>(
            Arrays.asList(SearchShortestDistanceMenu.MENU_NAME, SearchShortestTimeMenu.MENU_NAME, ExitMenu.MENU_NAME));

    public static final Map<String, MainMenu> mainMenu = new HashMap<>();
    public static final Map<String, SearchMenu> searchMenu = new HashMap<>();

    static {
        mainMenu.put(SearchPathMenu.MENU_BUTTON, new SearchPathMenu());

        searchMenu.put(SearchShortestDistanceMenu.MENU_BUTTON, new SearchShortestDistanceMenu());
        searchMenu.put(SearchShortestTimeMenu.MENU_BUTTON, new SearchShortestTimeMenu());
    }

}
