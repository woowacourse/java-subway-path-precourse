package subway.view;

public enum ErrorMessage {

	WRONG_MENU("\n[ERROR] 선택할 수 없는 기능 입니다."),
	WRONG_STATION("\n[ERROR] 존재하지 않는 역 입니다."),
	SAME_FROM_TO("\n[ERROR] 출발지와 도착지가 같습니다."),
	NO_PATH("\n[ERROR] 경로가 존재하지 않습니다.");
	
	final private String message;
	
	ErrorMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
