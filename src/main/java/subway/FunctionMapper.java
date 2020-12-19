package subway;

import subway.view.screen.exception.NotSupportedFunctionException;

import java.util.HashMap;
import java.util.Map;

public class FunctionMapper {
    public static final Map<String, Runnable> MAIN_FUNCTION_MAPPER = new HashMap<>();
    public static final Map<String, Runnable> ROUTE_FUNCTION_MAPPER = new HashMap<>();

    private static final String ONE = "1";
    private static final String TWO = "2";
    private static final String QUIT = "Q";
    private static final String BACK = "B";

    static {
        MAIN_FUNCTION_MAPPER.put(QUIT, Status::terminate);
    }

    public static Runnable matchMainFunction(Map<String, Runnable> mapper, String command) {
        return mapper.entrySet().stream()
                .filter(entry -> entry.getKey().equals(command))
                .map(Map.Entry::getValue)
                .findAny()
                .orElseThrow(NotSupportedFunctionException::new);
    }
}
