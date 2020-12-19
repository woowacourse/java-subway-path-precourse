package subway.controller.util;

import java.util.regex.Pattern;

public class InputValidator {
	final static String MAIN_MENU_INPUT_REGULAR_EXPRESS = "^[1Q]{1}$";
	final static String MENU_INPUT_ERROR = "\n[ERROR] 선택할 수 없는 기능 입니다.";
	
	public static void validateMainMenuInput(String input) throws
		IllegalArgumentException {
		if (!Pattern.matches(MAIN_MENU_INPUT_REGULAR_EXPRESS, input)) {
			throw new IllegalArgumentException(MENU_INPUT_ERROR);
		}
	}
}
