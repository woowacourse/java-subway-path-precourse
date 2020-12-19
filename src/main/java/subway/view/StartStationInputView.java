package subway.view;

import java.util.Scanner;

import subway.domain.StationRepository;

public class StartStationInputView extends SubwayPathManagerView {
	private static final String TOP_MENU_MESSAGE = "출발역을 입력하세요";

	private String input;

	public StartStationInputView(Scanner scanner) {
		print();
		inputStation(scanner);
	}

	public String getInput() {
		return input;
	}

	private void inputStation(Scanner scanner) {
		input = scanner.nextLine();
		StationRepository.checkExistStationByName(input);
	}

	@Override
	public void print() {
		printTopMenu(TOP_MENU_MESSAGE);
	}
}
