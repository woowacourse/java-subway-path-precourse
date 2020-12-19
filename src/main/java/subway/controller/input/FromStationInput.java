package subway.controller.input;

import subway.controller.util.InputValidator;
import subway.view.IntroMessage;

public class FromStationInput extends InputController {
	private static FromStationInput fromStationInput;
	
	public FromStationInput() {
		this.INPUT_INTRO = IntroMessage.FROM_STATION.getMessage();
	}
	
	@Override
	protected void validateInput() throws IllegalArgumentException {
		InputValidator.validateStationExistence(userInput);
	}
	
	public static FromStationInput getInstance() {
		if (fromStationInput == null) {
			fromStationInput = new FromStationInput();
		}
		return fromStationInput;
	}
}
