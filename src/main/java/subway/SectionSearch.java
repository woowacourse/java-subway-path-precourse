package subway;

import java.util.Scanner;

import subway.domain.LineRepository;
import subway.domain.StationRepository;

public class SectionSearch {
	private static final String SEARCH_SELECT_MESSAGE = "## 경로 기준\n" + "1. 최단 거리\n" + "2. 최소 시간\n" + "B. 돌아가기\n\n"
			+ "## 원하는 기능을 선택하세요.";
	private static final String START_STATION_MESSAGE = "## 출발역을 입력하세요.";
	private static final String END_STATION_MESSAGE = "## 도착역을 입력하세요.";
	private static final String RESULT_SEARCH_MESSAGE = "## 조회 결과.";
	private static final String ERROR_INPUT_MESSAGE = "[ERROR] 잘못된 입력값 입니다.\n";

	public static void selectSerchMenu(Scanner scanner, StationRepository stationRepositiory,
			LineRepository lineRepositiory) {
		while (true) {
			System.out.println(SEARCH_SELECT_MESSAGE);
			String select = scanner.nextLine();
			if (select.equals("1")) {
				minLengthSearch(scanner, stationRepositiory, lineRepositiory);
				return;
			}
			if (select.equals("2")) {
				minTimeSearch(scanner, stationRepositiory, lineRepositiory);
				return;
			}
			if (select.equals("B") || select.equals("b")) {
				return;
			}
			System.out.println(ERROR_INPUT_MESSAGE);
		}
	}

	private static void minLengthSearch(Scanner scanner, StationRepository stationRepositiory,
			LineRepository lineRepositiory) {
		System.out.println(START_STATION_MESSAGE);
		String startStation = scanner.nextLine();
		System.out.println(END_STATION_MESSAGE);
		String endStation = scanner.nextLine();
		
	}

	private static void minTimeSearch(Scanner scanner, StationRepository stationRepositiory,
			LineRepository lineRepositiory) {
		System.out.println(START_STATION_MESSAGE);
		String startStation = scanner.nextLine();
		System.out.println(END_STATION_MESSAGE);
		String endStation = scanner.nextLine();
	}
}
