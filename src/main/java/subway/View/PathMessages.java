package subway.View;

public enum PathMessages {
	PATH_0(GeneralMessages.BASIC.getMessage() + "경로 기준"),
	PATH_1(GeneralMessages.ONE.getMessage() + "최단 거리"),
	PATH_2(GeneralMessages.TWO.getMessage() + "최소 시간"),
	PATH_B(GeneralMessages.BACK.getMessage() + "돌아가기");

	final private String message;

	PathMessages(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
