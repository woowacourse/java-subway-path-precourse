package subway.controller;

import java.util.Arrays;
import java.util.List;

import subway.view.InputView;
import subway.view.OutputView;

enum RouteButton {
	SHORTEST_DISTANCE("1"), SHORTEST_TIME("2"), BACK_TO_MAIN("B");

	private final String button;

	RouteButton(String button) {
		this.button = button;
	}

	public String getButton() {
		return button;
	}
}

public class RouteManagement {
	private static final List<String> menu = Arrays.asList(RouteButton.SHORTEST_DISTANCE.getButton(),
			RouteButton.SHORTEST_TIME.getButton(), RouteButton.BACK_TO_MAIN.getButton());

	public static void execute() {
		OutputView.printRoutestandard();
		String fuction = InputView.selectFunction();
		proceduresExecute(fuction);
	}

	public static void proceduresExecute(String input) {
		if (input.equals(RouteButton.BACK_TO_MAIN.getButton())) {
			MainManagement.execute();
			return;
		} else if (input.equals(RouteButton.SHORTEST_DISTANCE.getButton())) {
			OutputView.printMap();
		} else if (input.equals(RouteButton.SHORTEST_TIME.getButton())) {
			OutputView.printMap();
		}
	}

}
