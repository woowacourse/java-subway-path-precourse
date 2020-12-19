package subway;

import static subway.common.ErrorCase.FUNCTION_INPUT_ERROR;
import static subway.common.ErrorCase.NO_SUCH_STATION_ERROR;
import static subway.common.ErrorCase.SAME_DEPARTURE_ARRIVAL_ERROR;
import static subway.common.ErrorCase.UNCONNECTED_DEPARTURE_ARRIVAL_ERROR;
import static subway.common.Logger.errorPrint;
import static subway.domain.Graph.DISTANCE_GRAPH;
import static subway.domain.Graph.TIME_GRAPH;
import static subway.domain.Graph.getDistanceByVertexList;
import static subway.domain.Graph.getTimeByVertexList;
import static subway.domain.StationRepository.getStationByName;
import static subway.view.InputView.inputArrivalStation;
import static subway.view.InputView.inputDepartureStation;
import static subway.view.InputView.inputFunctionNumber;
import static subway.view.OutputView.printLookUpResult;
import static subway.view.OutputView.printPathTypes;

import java.util.List;
import java.util.Scanner;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;

public class RouteLookUpManage {
	private final static String SHORTEST_DISTANCE = "1";
	private final static String MINIMUM_TIME = "2";
	private final static String BACK = "B";

	public static void routeLookUpManage(Scanner scanner) {
		boolean exitFlag = false;
		while (!exitFlag) {
			printPathTypes();
			exitFlag = isLookUpExit(scanner);
		}
	}

	private static boolean isLookUpExit(Scanner scanner) {
		String input = inputFunctionNumber(scanner);
		if (input.equals(BACK)) {
			return true;
		}
		if (input.equals(SHORTEST_DISTANCE)) {
			return inputControl(scanner, SHORTEST_DISTANCE);
		}
		if (input.equals(MINIMUM_TIME)) {
			return inputControl(scanner, MINIMUM_TIME);
		}
		errorPrint(FUNCTION_INPUT_ERROR);
		return false;
	}

	private static boolean inputControl(Scanner scanner, String findType) {
		String departureStation = inputDepartureStation(scanner);
		if (!verifyExistStation(departureStation)) {
			return false;
		}
		String arrivalStation = inputArrivalStation(scanner);
		if (!verifyExistStation(arrivalStation)) {
			return false;
		}
		if (!verifyDifferentStation(departureStation, arrivalStation)) {
			return false;
		}
		if (findType.equals(SHORTEST_DISTANCE)) {
			return findPathByDistanceControl(departureStation, arrivalStation);
		}
		if (findType.equals(MINIMUM_TIME)) {
			return findPathByTimeControl(departureStation, arrivalStation);
		}
		errorPrint(FUNCTION_INPUT_ERROR);
		return false;
	}

	private static boolean findPathByDistanceControl(String departureStation,
		String arrivalStation) {
		GraphPath<String, DefaultWeightedEdge> path = findPathByDistance(departureStation,
			arrivalStation);
		if (!verifyPathConnected(path)) {
			return false;
		}

		List<String> pathStations = path.getVertexList();
		int totalDistance = (int) path.getWeight();
		int totalTime = getTimeByVertexList(pathStations);
		printLookUpResult(totalDistance, totalTime, pathStations);

		return true;
	}

	private static boolean findPathByTimeControl(String departureStation,
		String arrivalStation) {
		GraphPath<String, DefaultWeightedEdge> path = findPathByTime(departureStation,
			arrivalStation);
		if (!verifyPathConnected(path)) {
			return false;
		}

		List<String> pathStations = path.getVertexList();
		int totalTime = (int) path.getWeight();
		int totalDistance = getDistanceByVertexList(pathStations);
		printLookUpResult(totalDistance, totalTime, pathStations);
		return true;
	}

	private static boolean verifyExistStation(String stationName) {
		if (getStationByName(stationName) == null) {
			errorPrint(NO_SUCH_STATION_ERROR);
			return false;
		}
		return true;
	}

	private static boolean verifyDifferentStation(String departureStation,
		String arrivalStation) {
		if (departureStation.equals(arrivalStation)) {
			errorPrint(SAME_DEPARTURE_ARRIVAL_ERROR);
			return false;
		}
		return true;
	}

	private static boolean verifyPathConnected(GraphPath<String, DefaultWeightedEdge> path) {
		if (path == null) {
			errorPrint(UNCONNECTED_DEPARTURE_ARRIVAL_ERROR);
			return false;
		}
		return true;
	}

	private static GraphPath<String, DefaultWeightedEdge> findPathByDistance(
		String departureStation, String arrivalStation) {
		DijkstraShortestPath<String, DefaultWeightedEdge> shortestDistancePath = new DijkstraShortestPath<>(
			DISTANCE_GRAPH);
		return shortestDistancePath.getPath(departureStation, arrivalStation);
	}

	private static GraphPath<String, DefaultWeightedEdge> findPathByTime(String departureStation,
		String arrivalStation) {
		DijkstraShortestPath<String, DefaultWeightedEdge> shortestDistancePath = new DijkstraShortestPath<>(
			TIME_GRAPH);
		return shortestDistancePath.getPath(departureStation, arrivalStation);
	}
}
