package subway.Controller;

import subway.View.MainMessages;
import subway.View.Options;

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

	public static void run(Scanner scanner) {
		// TODO

	}

	private static void findLeastDistance(Scanner scanner) {
		// TODO
	}

	private static void findLeastTimeConsumed(Scanner scanner) {
		// TODO
	}
}
