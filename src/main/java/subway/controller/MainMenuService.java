package subway.controller;

import subway.domain.Menu;
import subway.view.mainview.MainMenu;
import java.util.Scanner;

public class MainMenuService {
	
	public static void selectMenu(String menuKey,
	                              Scanner scanner) throws IllegalArgumentException {
		runSelectMenu(MainMenu.mainMenus.get(menuKey), scanner);
	}
	
	private static void runSelectMenu(Menu selectedMenu, Scanner scanner) throws IllegalArgumentException {
		selectedMenu.run(scanner);
	}
}
