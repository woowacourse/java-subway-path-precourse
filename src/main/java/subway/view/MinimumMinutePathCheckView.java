package subway.view;

import java.util.List;
import java.util.Scanner;

import subway.domain.PathRepository;
import subway.util.DijkstraUtils;

public class MinimumMinutePathCheckView extends SubwayPathManagerView {
	private static final String TOP_MENU_MESSAGE = "조회 결과";

	private static final String RESULT_BORDER = "---";
	private static final String DISTANCE_PREFIX = "총 거리: ";
	private static final String DISTANCE_SUFFIX = "km";
	private static final String MINUTE_PREFIX = "총 소요 시간: ";
	private static final String MINUTE_SUFFIX = "분";

	private static String startStationName;
	private static String endStationName;

	private static List<String> shortestPath;

	private static int minimumDistance;
	private static int minimumMinute;

	public MinimumMinutePathCheckView(Scanner scanner) {
		try {
			getStation(scanner);
			calculate();
			print();
		} catch (IllegalArgumentException e) {
			printError(e.getMessage());
		}
		new MainView(scanner);
	}

	public void getStation(Scanner scanner) {
		startStationName = new StartStationInputView(scanner).getInput();
		endStationName = new EndStationInputView(scanner).getInput();
	}

	public void calculate() {
		shortestPath = DijkstraUtils.getPathByMinimumMinute(startStationName, endStationName);
		minimumDistance = PathRepository.findDistanceByStationNames(shortestPath);
		minimumMinute = PathRepository.findMinuteByStationNames(shortestPath);
	}

	public void printInfo() {
		printInfo(RESULT_BORDER);
		printInfo(DISTANCE_PREFIX + minimumDistance + DISTANCE_SUFFIX);
		printInfo(MINUTE_PREFIX + minimumMinute + MINUTE_SUFFIX);
		printInfo(RESULT_BORDER);
		for (String stationName : shortestPath) {
			printInfo(stationName);
		}
	}

	@Override
	public void print() {
		printTopMenu(TOP_MENU_MESSAGE);
		printInfo();
	}
}
