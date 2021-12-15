package subway.Controller;

import java.util.List;
import java.util.Scanner;

import subway.Controller.Run.Init;
import subway.Controller.Run.InputController;
import subway.Controller.Run.OutputController;
import subway.domain.Path.ShortestPath;
import subway.domain.Station;

public class StationsController {
	private final Scanner scanner;
	private List<Station> path = null;

	public StationsController(Scanner scanner) {
		this.scanner = scanner;
		start();
	}

	public void start() {
		Init.initiate();
		mainInput();

		boolean go = pathInput();
		if (!go) {
			return;
		}
		OutputController.getOutput(path);
		start();
	}

	private void mainInput() {
		String input = InputController.getMainInput(scanner);
		if (input.equals("Q")) {
			System.exit(0);
		}
	}

	private boolean pathInput() {
		String input = InputController.getStandardInput(scanner);
		if (input.equals("B")) {
			start();
			return false;
		}

		String start = InputController.getStartStationInput(scanner);
		String finish = InputController.getFinishStationInput(scanner);

		try {
			path = getPath(input, start, finish);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			pathInput();
			return false;
		}
		return true;
	}

	public List<Station> getPath(String input, String start, String finish) {
		List<Station> path = null;
		if (input.equals("1")) {
			path = new ShortestPath(start, finish).getDistancePath();
		}
		if (input.equals("2")) {
			path = new ShortestPath(start, finish).getTimePath();
		}
		return path;
	}
}
