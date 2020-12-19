package subway.controller;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import subway.domain.Menu;
import subway.domain.Station;
import subway.domain.SubwayMap;
import subway.view.pathview.PathMenu;

import java.util.List;
import java.util.Scanner;

public class PathMenuService {
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
}
