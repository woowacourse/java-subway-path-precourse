package subway.view;

import java.util.Scanner;

public class PathCheckView extends SubwayPathManagerView {
	private static final String TOP_MENU_MESSAGE = "경로 기준";
	private static final String FIRST_MENU_MESSAGE = "최단 거리";
	private static final String SECOND_MENU_MESSAGE = "최소 시간";
	private static final String BACK_MENU_MESSAGE = "돌아가기";

	public PathCheckView(Scanner scanner) {
		print();
		selectMenu(scanner);
	}

	private void selectMenu(Scanner scanner) {
		String menuSelected = scanner.nextLine();
		if (menuSelected.equals(FIRST_MENU)) {
			new MinimumDistancePathCheckView(scanner);
			return;
		}
		if (menuSelected.equals(SECOND_MENU)) {
			new MinimumMinutePathCheckView(scanner);
			return;
		}
		if (menuSelected.equals(BACK_MENU)) {
			new MainView(scanner);
		}
	}

	@Override
	public void print() {
		printTopMenu(TOP_MENU_MESSAGE);
		printFirstMenu(FIRST_MENU_MESSAGE);
		printSecondMenu(SECOND_MENU_MESSAGE);
		printBackMenu(BACK_MENU_MESSAGE);
	}
}
