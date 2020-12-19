package subway.view.pathview;

import subway.controller.PathMenuService;
import subway.controller.input.FromStationInput;
import subway.controller.input.ToStationInput;
import subway.domain.Menu;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.List;
import java.util.Scanner;

public class ShortestDistance implements Menu {
	private final static String MENU_NAME = "1. 최단 거리";
	private final static String MENU_KEY = "1";
	private static ShortestDistance shortestDistance;
	
	@Override
	public String getMenuName() {
		return MENU_NAME;
	}
	
	@Override
	public String getMenuKey() {
		return MENU_KEY;
	}
	
	@Override
	public void run(Scanner scanner) throws IllegalArgumentException {
		Station from  = StationRepository.findStationByName(
			ToStationInput.getInstance().getUserInput(scanner));
		Station to = StationRepository.findStationByName(
			FromStationInput.getInstance().getUserInput(scanner));
		List<Station> pathFound = PathMenuService.findShortestDistancePath(from, to);
		double totalDistance = PathMenuService.getShortestDistancePathWeight(from, to);
		
	}
	
	public static Menu getInstance() {
		if (shortestDistance == null) {
			shortestDistance = new ShortestDistance();
		}
		return shortestDistance;
	}
}
