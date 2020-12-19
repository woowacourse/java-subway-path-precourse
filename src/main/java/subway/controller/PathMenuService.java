package subway.controller;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import subway.domain.Menu;
import subway.domain.Station;
import subway.domain.SubwayMap;
import subway.view.pathview.PathMenu;

import java.util.List;
import java.util.Scanner;

public class PathMenuService {
	private static final String SAME_FROM_TO = "\n[ERROR] 출발지와 도착지가 같습니다.";
	private static final String NO_PATH = "\n[ERROR] 경로가 존재하지 않습니다.";
	
	public static void selectMenu(String menuKey,
	                              Scanner scanner) throws IllegalArgumentException {
		runSelectMenu(PathMenu.pathMenus.get(menuKey), scanner);
	}
	
	private static void runSelectMenu(Menu selectedMenu, Scanner scanner) throws IllegalArgumentException {
		selectedMenu.run(scanner);
	}
	
	public static List<Station> findShortestDistancePath(Station from, Station to) {
		DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(SubwayMap.getDistanceMap());
		List<Station> shortestDistancePath = dijkstraShortestPath.getPath(from, to).getVertexList();
		return shortestDistancePath;
	}
	
	public static List<Station> findShortestTimePath(Station from, Station to) {
		DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(SubwayMap.getTimeMap());
		List<Station> shortestTimePath = dijkstraShortestPath.getPath(from, to).getVertexList();
		return shortestTimePath;
	}
	
	public static double getShortestDistancePathWeight(Station from, Station to) {
		DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(SubwayMap.getDistanceMap());
		return dijkstraShortestPath.getPathWeight(from, to);
	}
	
	public static double getShortestTimePathWeight(Station from, Station to) {
		DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(SubwayMap.getTimeMap());
		return dijkstraShortestPath.getPathWeight(from, to);
	}
	
	public static void validateFromToDifference(Station from, Station to) throws
		IllegalArgumentException {
		if(from == to) {
			throw new IllegalArgumentException(SAME_FROM_TO);
		}
	}
	
	public static void validateIfPathExist(List<Station> path) throws
		IllegalArgumentException {
		if(path == null) {
			throw new IllegalArgumentException(NO_PATH);
		}
	}
}
