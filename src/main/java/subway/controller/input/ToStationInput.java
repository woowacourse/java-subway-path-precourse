package subway.controller.input;

import subway.controller.util.InputValidator;

public class ToStationInput extends InputController {
	private static ToStationInput toStationInput;
	
	public ToStationInput() {
		this.INPUT_INTRO = "\n## 도착역을 입력하세요.";
	}
	
	@Override
	protected void validateInput() throws IllegalArgumentException {
		InputValidator.validateStationExistence(userInput);
	}
	
	public static ToStationInput getInstance() {
		if (toStationInput == null) {
			toStationInput = new ToStationInput();
		}
		return toStationInput;
	}
}
