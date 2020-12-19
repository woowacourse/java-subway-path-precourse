package subway;

public enum Error {
    OK("오류 없음"),
    INVALID_MENU("존재하지 않는 기능입니다."),
    SAME_STATIONS("출발역과 도착역이 동일합니다."),
    STATION_NOT_EXISTS("존재하지 않는 역입니다.");
    
    private final String message;
    
    private Error(String message) {
        this.message = message;
    }
    
    public String getMessage() {
        return message;
    }
}
