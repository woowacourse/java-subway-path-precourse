package subway.view;

import java.util.Scanner;

public class EndStationInputView extends SubwayPathManagerView {
	private static final String TOP_MENU_MESSAGE = "도착역을 입력하세요";

	private String input;

	public EndStationInputView(Scanner scanner) {
		print();
		inputStation(scanner);
	}

	public String getInput() {
		return input;
	}

	private void inputStation(Scanner scanner) {
		input = scanner.nextLine();
	}

	@Override
	public void print() {
		printTopMenu(TOP_MENU_MESSAGE);
	}
}
