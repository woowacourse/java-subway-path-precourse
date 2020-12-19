package subway.controller;

import subway.controller.input.MainMenuInput;
import subway.domain.*;
import subway.view.mainview.MainMenu;
import java.util.Scanner;

public class SubwayPathApplication {
	
	public static void init() {
		initStation();
		initLine();
		initInterval();
	}
	
	private static void initStation() {
		addStation(makeStation("교대역"));
		addStation(makeStation("강남역"));
		addStation(makeStation("역삼역"));
		addStation(makeStation("남부터미널역"));
		addStation(makeStation("양재역"));
		addStation(makeStation("양재시민의숲역"));
		addStation(makeStation("매봉역"));
	}
	
	private static void initLine() {
		addLine(makeLine("2호선"));
		addLine(makeLine("3호선"));
		addLine(makeLine("신분당선"));
	}
	
	private static void initInterval() {
		initLine2Map();
		initLine3Map();
		initLineShinBundangMap();
	}
	
	private static Station makeStation(String stationName) {
		return new Station(stationName);
	}
	
	private static void addStation(Station newStation) {
		StationRepository.addStation(newStation);
	}
	
	private static Line makeLine(String lineName) {
		return new Line(lineName);
	}
	
	private static void addLine(Line newLine) {
		LineRepository.addLine(newLine);
	}
	
	private static void initLine2Map() {
		SubwayMap.makePathWithDistance(StationRepository.findStationByName("교대역"),
			StationRepository.findStationByName("강남역"), 2);
		SubwayMap.makePathWithDistance(StationRepository.findStationByName("강남역"),
			StationRepository.findStationByName("역삼역"), 2);
		
		SubwayMap.makePathWithTime(StationRepository.findStationByName("교대역"),
			StationRepository.findStationByName("강남역"), 3);
		SubwayMap.makePathWithTime(StationRepository.findStationByName("강남역"),
			StationRepository.findStationByName("역삼역"), 3);
	}
	
	private static void initLine3Map() {
		SubwayMap.makePathWithDistance(StationRepository.findStationByName("교대역"),
			StationRepository.findStationByName("남부터미널역"), 3);
		SubwayMap.makePathWithDistance(StationRepository.findStationByName("남부터미널역"),
			StationRepository.findStationByName("양재역"), 6);
		SubwayMap.makePathWithDistance(StationRepository.findStationByName("양재역"),
			StationRepository.findStationByName("매봉역"), 1);
		SubwayMap.makePathWithTime(StationRepository.findStationByName("교대역"),
			StationRepository.findStationByName("남부터미널역"), 2);
		SubwayMap.makePathWithTime(StationRepository.findStationByName("남부터미널역"),
			StationRepository.findStationByName("양재역"), 5);
		SubwayMap.makePathWithTime(StationRepository.findStationByName("양재역"),
			StationRepository.findStationByName("매봉역"), 1);
	}
	
	private static void initLineShinBundangMap() {
		SubwayMap.makePathWithDistance(StationRepository.findStationByName("강남역"),
			StationRepository.findStationByName("양재역"), 2);
		SubwayMap.makePathWithDistance(StationRepository.findStationByName("양재역"),
			StationRepository.findStationByName("양재시민의숲역"), 10);
		
		SubwayMap.makePathWithTime(StationRepository.findStationByName("강남역"),
			StationRepository.findStationByName("양재역"), 8);
		SubwayMap.makePathWithTime(StationRepository.findStationByName("양재역"),
			StationRepository.findStationByName("양재시민의숲역"), 3);
	}
	
	public static void run(Scanner scanner) {
		String selectedMenu = "";
		init();
		
		while (!selectedMenu.equals("Q")) {
			try {
				MainMenu.getInstance().printMenu();
				selectedMenu = MainMenuInput.getInstance().getUserInput(scanner);
				MainMenuService.selectMenu(selectedMenu, scanner);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
