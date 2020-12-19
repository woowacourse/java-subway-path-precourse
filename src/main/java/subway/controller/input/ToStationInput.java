package subway.controller.input;

import subway.controller.util.InputValidator;
import subway.view.IntroMessage;

public class ToStationInput extends InputController {
	private static ToStationInput toStationInput;
	
	public ToStationInput() {
		this.INPUT_INTRO = IntroMessage.TO_STATION.getMessage();
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
