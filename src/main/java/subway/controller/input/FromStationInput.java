package subway.controller.input;

import subway.controller.util.InputValidator;

public class FromStationInput extends InputController {
	private static FromStationInput fromStationInput;
	
	public FromStationInput() {
		this.INPUT_INTRO = "\n## 출발역을 입력하세요."; //TODO ENUM
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
