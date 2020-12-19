package subway.controller.inputmenu;

import subway.controller.InputController;
import subway.controller.util.InputValidator;

public class PathMenuInput extends InputController {
	private static PathMenuInput pathMenuInput;
	
	public PathMenuInput() {
		this.INPUT_INTRO = "\n## 원하는 기능을 선택하세요."; //TODO enum 으로 관리
	}
	
	@Override
	protected void validateInput() {
		InputValidator.validatePathMenuInput(userInput);
	}
	
	public static PathMenuInput getInstance() {
		if (pathMenuInput == null) {
			pathMenuInput = new PathMenuInput();
		}
		return pathMenuInput;
	}
}