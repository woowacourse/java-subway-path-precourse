package subway.domain.util;

import subway.view.OutputView;

import java.util.function.Supplier;

public class ExceptionHandler {

    public static <T> T repeatForValidInput(Supplier<T> doAction) {
        while (true) {
            try {
                return doAction.get();
            } catch (IllegalArgumentException e) {
                OutputView.print(e.getMessage());
            }
        }
    }

}
