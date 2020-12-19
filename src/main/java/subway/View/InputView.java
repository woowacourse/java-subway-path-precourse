package subway.View;

import subway.domain.LineRepository;

import java.util.Scanner;

public class InputView {
	public static String inputStartStation(Scanner scanner) throws IllegalArgumentException {
		System.out.println(PathMessages.START.getMessage());
		String start = scanner.nextLine().replaceAll("\\s+", "");
		LineRepository.validateStationInUse(start);
		return start;
	}

	private static void validateSameStartAndEnd(String start, String end) throws IllegalArgumentException {
		if (start.equals(end)) {
			throw new IllegalArgumentException(PathMessages.SAME_START_END_ERROR.getMessage());
		}
	}

	public static String inputEndStation(Scanner scanner, String start) throws IllegalArgumentException {
		System.out.println(PathMessages.START.getMessage());
		String end = scanner.nextLine().replaceAll("\\s+", "");
		LineRepository.validateStationInUse(end);
		validateSameStartAndEnd(start, end);
		return end;
	}
}
