package subway.controller;

import subway.controller.inputmenu.MainMenuInput;
import subway.view.mainview.MainMenu;
import java.util.Scanner;

public class SubwayPathApplication {
	
	public static void run(Scanner scanner) {
		String selectedMenu = "";
		
		while (!selectedMenu.equals("Q")) {
			try {
				MainMenu.getInstance().printMenu();
				selectedMenu = MainMenuInput.getInstance().getUserInput(scanner);
				MainMenuService.selectMenu(selectedMenu, scanner);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
