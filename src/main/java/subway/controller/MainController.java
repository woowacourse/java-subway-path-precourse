package subway.controller;

import subway.view.InputView;
import subway.view.MainMessages;
import subway.view.Options;
import subway.view.OutputView;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;

public class MainController {
	private static final Map<String, Consumer<Scanner>> options = new HashMap<>();

	static {
		options.put(Options.OPTION_1.getOption(), PathController::run);
		options.put(Options.QUIT.getOption(), (scanner) -> System.out.println(MainMessages.QUIT.getMessage()));
	}

	private static void controlByOption(String option, Scanner scanner) {
		options.get(option).accept(scanner);
		if (option.equals(Options.QUIT.getOption())) {
			return;
		}
		OutputView.printMainScreen();
		run(scanner);
	}

	public static void run(Scanner scanner) {
		//TODO
		try {
			String option = InputView.inputScreenOption(scanner, options);
			controlByOption(option, scanner);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			System.out.println();
			run(scanner);
		}
	}
}
