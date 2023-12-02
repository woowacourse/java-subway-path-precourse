package subway.util.exception;

public class SameStationException extends IllegalArgumentException{
    public SameStationException(String message){
        super(message);
    }
}
