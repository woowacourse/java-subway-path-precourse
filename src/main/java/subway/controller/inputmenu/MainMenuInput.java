package subway.controller.inputmenu;

import subway.controller.InputController;
import subway.controller.util.InputValidator;

public class MainMenuInput extends InputController {
	private static MainMenuInput mainMenuInput;
	
	public MainMenuInput() {
		this.INPUT_INTRO = "\n## 원하는 기능을 선택하세요."; //TODO enum 으로 관리
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
