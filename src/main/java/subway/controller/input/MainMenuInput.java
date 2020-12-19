package subway.controller.input;

import subway.controller.util.InputValidator;
import subway.view.IntroMessage;

public class MainMenuInput extends InputController {
	private static MainMenuInput mainMenuInput;
	
	public MainMenuInput() {
		this.INPUT_INTRO = IntroMessage.SELECT_MENU.getMessage();
	}
	
	@Override
	protected void validateInput() throws IllegalArgumentException {
		InputValidator.validateMainMenuInput(userInput);
	}
	
	public static MainMenuInput getInstance() {
		if (mainMenuInput == null) {
			mainMenuInput = new MainMenuInput();
		}
		return mainMenuInput;
	}
}
