package subway.controller.input;

import subway.controller.util.InputValidator;
import subway.view.IntroMessage;

public class PathMenuInput extends InputController {
	private static PathMenuInput pathMenuInput;
	
	public PathMenuInput() {
		this.INPUT_INTRO = IntroMessage.SELECT_MENU.getMessage();
	}
	
	@Override
	protected void validateInput() throws IllegalArgumentException {
		InputValidator.validatePathMenuInput(userInput);
	}
	
	public static PathMenuInput getInstance() {
		if (pathMenuInput == null) {
			pathMenuInput = new PathMenuInput();
		}
		return pathMenuInput;
	}
}