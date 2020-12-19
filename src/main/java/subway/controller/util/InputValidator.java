package subway.controller.util;

import subway.domain.StationRepository;
import subway.view.ErrorMessage;

import java.util.regex.Pattern;

public class InputValidator {
	final static String MAIN_MENU_INPUT_REGULAR_EXPRESS = "^[1Q]{1}$";
	final static String PATH_MENU_INPUT_REGULAR_EXPRESS = "^[1-2B]{1}$";
	
	public static void validateMainMenuInput(String input) throws
		IllegalArgumentException {
		if (!Pattern.matches(MAIN_MENU_INPUT_REGULAR_EXPRESS, input)) {
			throw new IllegalArgumentException(ErrorMessage.WRONG_MENU.getMessage());
		}
	}
	
	public static void validatePathMenuInput(String input) throws
		IllegalArgumentException {
		if (!Pattern.matches(PATH_MENU_INPUT_REGULAR_EXPRESS, input)) {
			throw new IllegalArgumentException(ErrorMessage.WRONG_MENU.getMessage());
		}
	}
	
	public static void validateStationExistence(String target) throws
		IllegalArgumentException {
		if (!StationRepository.findByName(target)) {
			throw new IllegalArgumentException(ErrorMessage.WRONG_STATION.getMessage());
		}
	}
}
