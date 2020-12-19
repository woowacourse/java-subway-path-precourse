package subway.view;

import subway.domain.Menu;
import java.util.Scanner;

public class Return implements Menu {
	private final static String MENU_NAME = "B. 돌아가기";
	private final static String MENU_KEY = "B";
	private static Return returnMenu;
	
	private Return() {}
	
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
		if (returnMenu == null) {
			returnMenu = new Return();
		}
		return returnMenu;
	}
}
