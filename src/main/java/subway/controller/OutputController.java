package subway.controller;

import subway.domain.Menu;
import subway.domain.Station;

import java.util.List;
import java.util.Map;

public class OutputController {
	private static final String RESULT_INTRO = "\n## 조회 결과";
	private static final String INFO_INTRO = "[INFO] ";
	private static final String BREAK_LINE = "---";
	private static final String TOTAL_DISTANCE = "총 거리: ";
	private static final String TOTAL_TIME = "총 소요 시간: ";
	private static final String DISTANCE_UNIT = "km";
	private static final String TIME_UNIT = "분";
	
	public static void printMainMenu(Map<String, Menu> menu, String menuIntro) {
		System.out.println(menuIntro);
		
		for (String key: menu.keySet()) {
			System.out.println(menu.get(key).getMenuName());
		}
	}
	
	public static void printDistancePath(List<Station> path, double weight) {
		System.out.println(RESULT_INTRO);
		System.out.println(INFO_INTRO + BREAK_LINE);
		System.out.println(INFO_INTRO + TOTAL_DISTANCE + weight + DISTANCE_UNIT);
		System.out.println(INFO_INTRO + BREAK_LINE);
		path.stream().forEach(station -> {
			System.out.println(INFO_INTRO + station.getName());
		});
	}
	
	public static void printTimePath(List<Station> path, double weight) {
		System.out.println(RESULT_INTRO);
		System.out.println(INFO_INTRO + BREAK_LINE);
		System.out.println(INFO_INTRO + TOTAL_TIME + weight + TIME_UNIT);
		System.out.println(INFO_INTRO + BREAK_LINE);
		path.stream().forEach(station -> {
			System.out.println(INFO_INTRO + station.getName());
		});
	}
}
