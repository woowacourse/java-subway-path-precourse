package subway;

import java.util.Scanner;

import subway.domain.LineRepository;
import subway.domain.StationRepository;

public class SectionSearch {
	private static final String SEARCH_SELECT_MESSAGE = "\n## 경로 기준\n" + "1. 최단 거리\n" + "2. 최소 시간\n" + "B. 돌아가기\n\n"
			+ "## 원하는 기능을 선택하세요.";
	private static final String START_STATION_MESSAGE = "\n## 출발역을 입력하세요.";
	private static final String END_STATION_MESSAGE = "\n## 도착역을 입력하세요.";
	private static final String RESULT_SEARCH_MESSAGE = "\n## 조회 결과.";
	private static final String ERROR_INPUT_MESSAGE = "[ERROR] 잘못된 입력값입니다.\n";
	private static final String ERROR_EQUALS_STATION = "[ERROR] 출발역과 도착역이 동일합니다.\n";
	private static final String ERROR_NOTFIND_STATION = "[ERROR] 없는 역이름입니다.\n";

	public static void sectionSearchMenu(Scanner scanner, StationRepository stationRepositiory, LineRepository lineRepositiory) {
		boolean end = false;
		while (!end) {
			System.out.println(SEARCH_SELECT_MESSAGE);
			end = selectSerchMenu(scanner, stationRepositiory, lineRepositiory);
		}
	}
	
	private static boolean selectSerchMenu(Scanner scanner, StationRepository stationRepositiory,
			LineRepository lineRepositiory) {
		boolean end = true;
		while (end) {
			String select = scanner.nextLine();
			if (select.equals("1") || select.equals("2")) {
				end = searchInput(scanner, select, stationRepositiory);
				return end;
			}
			if (select.equals("B") || select.equals("b")) {
				return false;
			}
			System.out.println(ERROR_INPUT_MESSAGE);
			return true;
		}
		System.out.println(ERROR_INPUT_MESSAGE);
		return false;
	}

	private static boolean searchInput(Scanner scanner, String select, StationRepository stationRepositiory) {
		System.out.println(START_STATION_MESSAGE);
		String startStation = scanner.nextLine();
		if (!inputErrorCheck(stationRepositiory, startStation))
			return false;
		System.out.println(END_STATION_MESSAGE);
		String endStation = scanner.nextLine();
		if (!inputErrorCheck(stationRepositiory, endStation))
			return false;
		if (!inputErrorCheck(startStation, endStation))
			return false;
		if (select.equals("1")) {
			minLengthSearch();
			return true;
		}
		if (select.equals("2")) {
			minTimeSearch();
			return true;
		}
		System.out.println(ERROR_INPUT_MESSAGE);
		return false;
	}

	private static boolean inputErrorCheck(StationRepository stationRepositiory, String station) {
		if(stationRepositiory.findStation(station))
			return true;
		System.out.println(ERROR_NOTFIND_STATION);
		return false;
	}

	private static boolean inputErrorCheck(String startStation, String endStation) {
		if (!startStation.equals(endStation))
			return true;
		System.out.println(ERROR_EQUALS_STATION);
		return false;
	}

	private static void minTimeSearch() {
	}

	private static void minLengthSearch() {
	}

}
