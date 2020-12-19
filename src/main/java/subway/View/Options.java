package subway.View;

import subway.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;

public enum Options {
	OPTION_1("1"),
	OPTION_2("2"),
	BACK("B"),
	QUIT("Q");

	private final String option;

	Options(String option) {
		this.option = option;
	}

	private static List<String> getOptionList(Map<String, Consumer<Scanner>> options) {
		return new ArrayList<>(options.keySet());
	}

	public static void validateOption(Map<String, Consumer<Scanner>> options, String input) throws IllegalArgumentException {
		if (!hasOption(getOptionList(options), input)) {
			throw new IllegalArgumentException(GeneralMessages.NOT_AVAILABLE_OPTION_ERROR.getMessage());
		}
	}

	private static boolean hasOption(List<String> options, String input) {
		return options.stream()
				.anyMatch(option -> option.equals(input));
	}

	public String getOption() {
		return option;
	}
}
