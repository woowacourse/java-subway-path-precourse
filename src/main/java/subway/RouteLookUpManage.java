package subway;

import static subway.common.ErrorCase.FUNCTION_INPUT_ERROR;
import static subway.common.ErrorCase.NO_SUCH_STATION_ERROR;
import static subway.common.ErrorCase.SAME_DEPARTURE_ARRIVAL_ERROR;
import static subway.common.ErrorCase.UNCONNECTED_DEPARTURE_ARRIVAL_ERROR;
import static subway.common.Logger.errorPrint;
import static subway.domain.Graph.DISTANCE_GRAPH;
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
	static boolean ERROR_FLAG = false;

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
			return findPathByDistanceControl(scanner);
		}
		if (input.equals(MINIMUM_TIME)) {
			//findPathByTime(scanner);
			return false;
		}
		errorPrint(FUNCTION_INPUT_ERROR);
		return false;
	}

	private static boolean findPathByDistanceControl(Scanner scanner) {
		String departureStation = inputDepartureStation(scanner);
		if (!verifyExistStation(departureStation)) {
			return false;
		}

		String arrivalStation = inputArrivalStation(scanner);
		if (!verifyExistStation(arrivalStation)) {
			return false;
		}
		if (!verifyDepartArrivalStation(departureStation, arrivalStation)) {
			return false;
		}

		findPathByDistance(departureStation, arrivalStation);
		return true;
	}

	private static boolean verifyExistStation(String stationName) {
		if (getStationByName(stationName) == null) {
			errorPrint(NO_SUCH_STATION_ERROR);
			return false;
		}
		return true;
	}

	private static boolean verifyDepartArrivalStation(String departureStation,
		String arrivalStation) {
		if (departureStation.equals(arrivalStation)) {
			errorPrint(SAME_DEPARTURE_ARRIVAL_ERROR);
			return false;
		}
		// TODO : UNCONNECTED ERROR handling
		return true;
	}

	private static void findPathByDistance(String departureStation, String arrivalStation) {
		DijkstraShortestPath<String, DefaultWeightedEdge> shortestDistancePath = new DijkstraShortestPath<>(
			DISTANCE_GRAPH);
		GraphPath<String, DefaultWeightedEdge> path = shortestDistancePath
			.getPath(departureStation, arrivalStation);

		List<String> pathStations = path.getVertexList();
		int totalDistance = (int) path.getWeight();
		int totalTime = getTimeByVertexList(pathStations);

		printLookUpResult(totalDistance, totalTime, pathStations);
	}
}
