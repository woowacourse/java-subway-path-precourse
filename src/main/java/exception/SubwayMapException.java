package exception;

public class SubwayMapException extends Exception {
    private static final String TAG = "[ERROR]";

    public SubwayMapException(String message) {
        System.out.println(TAG + message);
    }

}
