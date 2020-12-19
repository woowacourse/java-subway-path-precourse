package subway.view.pathview;

import subway.controller.PathMenuService;
import subway.controller.input.FromStationInput;
import subway.controller.input.ToStationInput;
import subway.domain.Menu;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.List;
import java.util.Scanner;

public class ShortestTime implements Menu {
	private final static String MENU_NAME = "2. 최소 시간";
	private final static String MENU_KEY = "2";
	private static ShortestTime shortestTime;
	
	@Override
	public String getMenuName() {
		return MENU_NAME;
	}
	
	@Override
	public String getMenuKey() {
		return MENU_KEY;
	}
	
	@Override
	public void run(Scanner scanner) {
		Station from  = StationRepository.findStationByName(
			ToStationInput.getInstance().getUserInput(scanner));
		Station to = StationRepository.findStationByName(
			FromStationInput.getInstance().getUserInput(scanner));
		List<Station> pathFound = PathMenuService.findShortestTimePath(from, to);
		double totalDistance = PathMenuService.getShortestTimePathWeight(from, to);
	}
	
	public static Menu getInstance() {
		if (shortestTime == null) {
			shortestTime = new ShortestTime();
		}
		return shortestTime;
	}
}
