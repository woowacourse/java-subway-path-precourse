package subway;

import java.util.Scanner;

import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.domain.SubwaySection;

public class SectionSearch {
	private static final String SEARCH_SELECT_MESSAGE = "\n## 경로 기준\n" + "1. 최단 거리\n" + "2. 최소 시간\n" + "B. 돌아가기\n\n"
			+ "## 원하는 기능을 선택하세요.";
	private static final String START_STATION_MESSAGE = "\n## 출발역을 입력하세요.";
	private static final String END_STATION_MESSAGE = "\n## 도착역을 입력하세요.";
	private static final String RESULT_SEARCH_MESSAGE = "\n## 조회 결과.";
	private static final String ERROR_INPUT_MESSAGE = "[ERROR] 잘못된 입력값입니다.\n";
	private static final String ERROR_EQUALS_STATION = "[ERROR] 출발역과 도착역이 동일합니다.\n";
	private static final String ERROR_NOTFIND_STATION = "[ERROR] 없는 역이름입니다.\n";

	public static void sectionSearchMenu(Scanner scanner, StationRepository stationRepositiory, SubwaySection subwaySection) {
		boolean end = false;
		while (!end) {
			System.out.println(SEARCH_SELECT_MESSAGE);
			end = selectSerchMenu(scanner, stationRepositiory, subwaySection);
		}
	}
	
	private static boolean selectSerchMenu(Scanner scanner, StationRepository stationRepositiory,
			SubwaySection subwaySection) {
		boolean end = true;
		while (end) {
			String select = scanner.nextLine();
			if (select.equals("1") || select.equals("2")) {
				end = searchInput(scanner, select, stationRepositiory, subwaySection);
				return end;
			}
			if (select.equals("B") || select.equals("b")) {
				System.out.println();
				return true;
			}
			System.out.println(ERROR_INPUT_MESSAGE);
			return false;
		}
		System.out.println(ERROR_INPUT_MESSAGE);
		return false;
	}

	private static boolean searchInput(Scanner scanner, String select, StationRepository stationRepositiory, SubwaySection subwaySection) {
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
			minLengthSearch(subwaySection, startStation, endStation);
			return true;
		}
		if (select.equals("2")) {
			minTimeSearch(subwaySection, startStation, endStation);
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

	private static void minLengthSearch(SubwaySection subwaySection, String startStation, String endStation) {
		subwaySection.minLengthSection(startStation, endStation);
	}

	private static void minTimeSearch(SubwaySection subwaySection, String startStation, String endStation) {
		subwaySection.minTimeSection(startStation, endStation);
	}

}
