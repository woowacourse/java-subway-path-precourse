package exception;

public class NoneFunctionException extends RuntimeException implements Exception{
    public final static String CAUSE = "존재하지 않는 기능입니다.";

    public NoneFunctionException(){
        super(ERROR + CAUSE);
    }
}
