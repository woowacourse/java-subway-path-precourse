package subway.controller;

import subway.domain.Menu;
import subway.view.pathview.PathMenu;

import java.util.Scanner;

public class PathMenuService {
	public static void selectMenu(String menuKey,
	                              Scanner scanner) throws IllegalArgumentException {
		runSelectMenu(PathMenu.pathMenus.get(menuKey), scanner);
	}
	
	private static void runSelectMenu(Menu selectedMenu, Scanner scanner) throws IllegalArgumentException {
		selectedMenu.run(scanner);
	}
}
