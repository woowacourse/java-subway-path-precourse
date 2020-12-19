package subway.view;

public enum IntroMessage {

	SELECT_MENU("\n## 원하는 기능을 선택하세요."),
	MAIN_MENU("\n## 메인 화면"),
	PATH_MENU("\n## 경로 기준");
	
	final private String message;
	
	IntroMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
