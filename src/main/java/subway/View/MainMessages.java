package subway.View;

public enum MainMessages {
	MAIN_0(GeneralMessages.BASIC.getMessage() + "메인 화면"),
	MAIN_1(GeneralMessages.ONE.getMessage() + "경로 조회"),
	MAIN_Q(GeneralMessages.QUIT.getMessage() + "종료"),

	QUIT(GeneralMessages.BASIC.getMessage() + "종료합니다.");

	final private String message;

	MainMessages(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
