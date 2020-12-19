package subway;

public enum Error {
    INVALID_MENU("존재하지 않는 기능입니다.");
    
    private final String message;
    
    private Error(String message) {
        this.message = message;
    }
    
    public String getMessage() {
        return message;
    }
}
