package subway.view;

import org.jgrapht.GraphPath;
import subway.domain.SubwayMap;

import java.util.Arrays;
import java.util.List;

public class OutputView {
	private static final int MAIN_SCREEN_OPTION_LENGTH = 3;
	private static final int PATH_SCREEN_OPTION_LENGTH = 4;

	public static void printMainScreen() {
		Arrays.stream(MainMessages.values())
				.limit(MAIN_SCREEN_OPTION_LENGTH)
				.forEach(value -> System.out.println(value.getMessage()));
		System.out.println();
	}

	public static void printPathScreen() {
		Arrays.stream(PathMessages.values())
				.limit(PATH_SCREEN_OPTION_LENGTH)
				.forEach(value -> System.out.println(value.getMessage()));
		System.out.println();
	}

	public static void printPathInformationForLeastDistance(GraphPath<String, String> shortestPath) {
		System.out.println(GeneralMessages.DIVISION_LINE.getMessage());
		System.out.printf(PathMessages.TOTAL_DISTANCE.getMessage() + "%n", Integer.parseInt(String.valueOf(Math.round(shortestPath.getWeight()))));
		System.out.printf(PathMessages.TOTAL_TIME.getMessage() + "%n", SubwayMap.getTimeSumOfLeastDistancePath(shortestPath));
		System.out.println(GeneralMessages.DIVISION_LINE.getMessage());
		for (String station : shortestPath.getVertexList()) {
			System.out.println(GeneralMessages.INFO.getMessage() + station);
		}
		System.out.println();
	}

	public static void printPathInformationForLeastTime(GraphPath<String, String> shortestPath) {
		System.out.println(GeneralMessages.DIVISION_LINE.getMessage());
		System.out.printf(PathMessages.TOTAL_DISTANCE.getMessage() + "%n", SubwayMap.getDistanceSumOfLeastTimePath(shortestPath));
		System.out.printf(PathMessages.TOTAL_TIME.getMessage() + "%n", Integer.parseInt(String.valueOf(Math.round(shortestPath.getWeight()))));
		System.out.println(GeneralMessages.DIVISION_LINE.getMessage());
		for (String station : shortestPath.getVertexList()) {
			System.out.println(GeneralMessages.INFO.getMessage() + station);
		}
		System.out.println();
	}
}
