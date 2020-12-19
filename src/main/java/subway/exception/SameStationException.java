package subway.exception;

public class SameStationException extends Exception {

    private final String name;

    public SameStationException(String name) {
        this.name = name;
    }

    @Override
    public String getMessage() {
        return "[ERROR] 출발역과 도착역이 " + name + "으로 동일합니다.";
    }
}
