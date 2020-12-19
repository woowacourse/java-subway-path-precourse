package subway.view.mainview;

import subway.domain.Menu;
import java.util.Scanner;

public class FindPath implements Menu {
	private final static String MENU_NAME = "1. 경로 조회";
	private final static String MENU_KEY = "1";
	private static FindPath findPath;
	
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
		if (findPath == null) {
			findPath = new FindPath();
		}
		return findPath;
	}
}
