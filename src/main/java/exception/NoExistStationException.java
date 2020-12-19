package exception;

public class NoExistStationException extends RuntimeException implements Exception{
    public final static String CAUSE = "존재하지 않는 역입니다.";

    public NoExistStationException(){
        super(ERROR + CAUSE);
    }
}
