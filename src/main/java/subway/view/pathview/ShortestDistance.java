package subway.view.pathview;

import subway.domain.Menu;
import subway.view.mainview.FindPath;

import java.util.Scanner;

public class ShortestDistance implements Menu {
	private final static String MENU_NAME = "1. 최단 거리";
	private final static String MENU_KEY = "1";
	private static ShortestDistance shortestDistance;
	
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
		if (shortestDistance == null) {
			shortestDistance = new ShortestDistance();
		}
		return shortestDistance;
	}
}
