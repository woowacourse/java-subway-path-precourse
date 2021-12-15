package subway.Controller;

import java.util.List;
import java.util.Scanner;

import subway.Utils.Constants;
import subway.View.OutputView;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Path.DistanceConnectionRepository;
import subway.domain.Path.ShortestPath;
import subway.domain.Path.TimeConnectionRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class StationsController {
	private final Scanner scanner;
	private List<Station> path = null;

	public StationsController(Scanner scanner) {
		this.scanner = scanner;
		start();
	}

	public void start() {
		initiate();
		mainInput();

		boolean go = pathInput();
		if (!go) {
			return;
		}

		output(path);

		start();
	}

	private void initiate() {
		setStationRepository();
		setLineRepository();
		setConnectionRepository();
		setDistanceConnectionRepository();
		setTimeConnectionRepository();
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

	private void output(List<Station> path) {
		OutputView.printResult();
		OutputView.printFullDistance(getFullDistance(path));
		OutputView.printFullTime(getFullTime(path));
		OutputView.printPath(path);
	}

	private void setStationRepository() {
		for (String s : Constants.STATIONS) {
			StationRepository.addStation(new Station(s));
		}
		DistanceConnectionRepository.addAllVertex();
		TimeConnectionRepository.addAllVertex();
	}

	private void setLineRepository() {
		for (String s : Constants.LINES) {
			LineRepository.addLine(new Line(s));
		}
	}

	private void setConnectionRepository() {
		for (Object[] distances : Constants.DISTANCES) {
			DistanceConnectionRepository.addConnection(
				StationRepository.getStation((String)distances[0]),
				StationRepository.getStation((String)distances[1]),
				(Integer)distances[2]);
		}
	}

	private void setDistanceConnectionRepository() {
		for (Object[] distances : Constants.DISTANCES) {
			DistanceConnectionRepository.addConnection(
				StationRepository.getStation((String)distances[0]),
				StationRepository.getStation((String)distances[1]),
				(Integer)distances[2]);
		}
	}

	private void setTimeConnectionRepository() {
		for (Object[] times : Constants.TIMES) {
			TimeConnectionRepository.addConnection(
				StationRepository.getStation((String)times[0]),
				StationRepository.getStation((String)times[1]),
				(Integer)times[2]);
		}
	}

	public static int getFullDistance(List<Station> path) {
		int fullDistance = 0;
		for (int i = 0; i < path.size() - 1; i++) {
			fullDistance += DistanceConnectionRepository.findDistance(
				path.get(i), path.get(i + 1)
			);
		}
		return fullDistance;
	}

	public static int getFullTime(List<Station> path) {
		int fullTime = 0;
		for (int i = 0; i < path.size() - 1; i++) {
			fullTime += TimeConnectionRepository.findTime(
				path.get(i), path.get(i + 1)
			);
		}
		return fullTime;
	}
}
