package subway.view.mainview;

import subway.domain.Menu;

import java.util.Scanner;

public class Exit implements Menu {
	private final static String MENU_NAME = "Q. 종료";
	private final static String MENU_KEY = "Q";
	private static Exit exit;
	
	@Override
	public String getMenuName() {
		return MENU_NAME;
	}
	
	@Override
	public String getMenuKey() {
		return MENU_KEY;
	}
	
	@Override
	public void run(Scanner scanner) {}
	
	public static Menu getInstance() {
		if (exit == null) {
			exit = new Exit();
		}
		return exit;
	}
}
