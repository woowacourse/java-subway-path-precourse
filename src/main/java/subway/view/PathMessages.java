package subway.view;

public enum PathMessages {
	PATH_0(GeneralMessages.BASIC.getMessage() + "경로 기준"),
	PATH_1(GeneralMessages.ONE.getMessage() + "최단 거리"),
	PATH_2(GeneralMessages.TWO.getMessage() + "최소 시간"),
	PATH_B(GeneralMessages.BACK.getMessage() + "돌아가기"),

	START(GeneralMessages.BASIC.getMessage() + "출발역을 입력하세요."),
	END(GeneralMessages.BASIC.getMessage() + "도착역을 입력하세요."),
	TOTAL_DISTANCE(GeneralMessages.INFO.getMessage() + "총 거리: %dkm"),
	TOTAL_TIME(GeneralMessages.INFO.getMessage() + "총 소요 시간: %d분"),

	SAME_START_END_ERROR(GeneralMessages.ERROR.getMessage() + "출발역과 도착역이 동일합니다."),
	STATION_NOT_IN_USE_ERROR(GeneralMessages.ERROR.getMessage() + "노선에 존재하지 않는 역입니다.");

	final private String message;

	PathMessages(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
