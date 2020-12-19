package subway.view.pathview;

import subway.domain.Menu;

import java.util.Scanner;

public class ShortestTime implements Menu {
	private final static String MENU_NAME = "2. 최소 시간";
	private final static String MENU_KEY = "2";
	private static ShortestTime shortestTime;
	
	@Override
	public String getMenuName() {
		return MENU_NAME;
	}
	
	@Override
	public String getMenuKey() {
		return MENU_KEY;
	}
	
	@Override
	public void run(Scanner scanner) {
	
	}
	
	public static Menu getInstance() {
		if (shortestTime == null) {
			shortestTime = new ShortestTime();
		}
		return shortestTime;
	}
}
