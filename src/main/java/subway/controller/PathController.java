package subway.controller;

import subway.view.Options;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;

public class PathController {
	private static final Map<String, Consumer<Scanner>> options = new HashMap<>();

	static {
		options.put(Options.OPTION_1.getOption(), PathController::findLeastDistance);
		options.put(Options.OPTION_2.getOption(), PathController::findLeastTimeConsumed);
		options.put(Options.QUIT.getOption(), (scanner) -> {});
	}

	private static void controlByOption(String option, Scanner scanner) {
		options.get(option).accept(scanner);
		if (option.equals(Options.BACK.getOption())) {
			return;
		}
		run(scanner);
	}

	private static void findLeastDistance(Scanner scanner) {
		// TODO
	}

	private static void findLeastTimeConsumed(Scanner scanner) {
		// TODO
	}

	public static void run(Scanner scanner) {
		// TODO

	}
}
