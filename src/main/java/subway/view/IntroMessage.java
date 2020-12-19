package subway.view;

public enum IntroMessage {

	SELECT_MENU("\n## 원하는 기능을 선택하세요."),
	MAIN_MENU("\n## 메인 화면"),
	PATH_MENU("\n## 경로 기준"),
	FROM_STATION("\n## 출발역을 입력하세요."),
	TO_STATION("## 도착역을 입력하세요.");
	
	final private String message;
	
	IntroMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
