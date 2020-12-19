package subway.view.pathview;

import subway.controller.OutputController;
import subway.domain.Menu;
import subway.view.Return;
import java.util.LinkedHashMap;

public class PathMenu {
	private static PathMenu pathView;
	public static LinkedHashMap<String, Menu> pathMenus = new LinkedHashMap<>();
	
	public PathMenu() {
		setMenu();
	}
	
	static void setMenu() {
		pathMenus.put(ShortestDistance.getInstance().getMenuKey(), ShortestDistance.getInstance());
		pathMenus.put(ShortestTime.getInstance().getMenuKey(), ShortestTime.getInstance());
		pathMenus.put(Return.getInstance().getMenuKey(), Return.getInstance());
	}
	
	public void printMenu() {
		OutputController.printMainMenu(pathMenus, "\n## 경로 기준"); //TODO enum으로 관리하기
	}
	
	public static PathMenu getInstance() {
		if (pathView == null) {
			pathView = new PathMenu();
		}
		return pathView;
	}
}
