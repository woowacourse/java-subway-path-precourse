package subway.view;

import subway.domain.LineRepository;

import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;

public class InputView {
	public static String inputScreenOption(Scanner scanner, Map<String, Consumer<Scanner>> options) throws IllegalArgumentException {
		System.out.println(GeneralMessages.CHOICE.getMessage());
		String option = scanner.nextLine().replaceAll("\\s+", "");
		System.out.println();
		Options.validateOption(options, option);
		return option;
	}

	public static String inputStartStation(Scanner scanner) throws IllegalArgumentException {
		System.out.println(PathMessages.START.getMessage());
		String start = scanner.nextLine().replaceAll("\\s+", "");
		System.out.println();
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
		System.out.println();
		LineRepository.validateStationInUse(end);
		validateSameStartAndEnd(start, end);
		return end;
	}
}
