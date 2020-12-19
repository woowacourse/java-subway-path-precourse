package subway.Controller;

import subway.View.MainMessages;
import subway.View.Options;

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



}
