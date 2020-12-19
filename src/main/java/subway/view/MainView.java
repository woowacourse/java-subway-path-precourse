package subway.view;

import java.util.Scanner;

public class MainView extends SubwayPathManagerView {
	private static final String TOP_MENU_MESSAGE = "메인 화면";
	private static final String FIRST_MENU_MESSAGE = "경로 조회";
	private static final String QUIT_MENU_MESSAGE = "종료";

	public MainView(Scanner scanner) {
		print();
		selectMenu(scanner);
	}

	private void selectMenu(Scanner scanner) {
		String menuSelected = scanner.nextLine();
		if (menuSelected.equals(FIRST_MENU)) {
			new PathCheckView(scanner);
			return;
		} 
		if (menuSelected.equals(QUIT_MENU)) {
			// Do nothing. Just Quit.
		}
	}

	@Override
	public void print() {
		printTopMenu(TOP_MENU_MESSAGE);
		printFirstMenu(FIRST_MENU_MESSAGE);
		printQuitMenu(QUIT_MENU_MESSAGE);
	}
}
