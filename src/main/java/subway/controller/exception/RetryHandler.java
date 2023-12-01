package subway.controller.exception;

import java.util.function.Supplier;
import subway.view.View;

public class RetryHandler {
    private final View view = new View();

    public <T> T getOrRetry(Supplier<T> supplier){
        while(true){
            try {
                return supplier.get();
            } catch (IllegalArgumentException e){
                view.printException(e.getMessage());
            } finally {
                view.printLine();
            }
        }
    }

    public void runOrRetry(Runnable runnable){
        while(true){
            try {
                runnable.run();
                return;
            } catch (IllegalArgumentException e){
                view.printException(e.getMessage());
            } finally {
                view.printLine();
            }
        }
    }
}
