package subway.view.mainview;

import subway.controller.OutputController;
import subway.domain.Menu;
import subway.view.Return;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class MainMenu {
	private static MainMenu mainMenu;
	public static LinkedHashMap<String, Menu> mainMenus = new LinkedHashMap<>();
	
	public MainMenu() {
		setMenu();
	}
	
	static void setMenu() {
		mainMenus.put(FindPath.getInstance().getMenuKey(), FindPath.getInstance());
		mainMenus.put(Return.getInstance().getMenuKey(), Return.getInstance());
	}
	
	public void printMenu() {
		OutputController.printMainMenu(mainMenus, "## 메인 화면"); //TODO enum으로 관리하기
	}
	
	public String getUserInput(Scanner scanner) {
		return null;
	}
	
	public static MainMenu getInstance() {
		if (mainMenu == null) {
			mainMenu = new MainMenu();
		}
		return mainMenu;
	}
}
