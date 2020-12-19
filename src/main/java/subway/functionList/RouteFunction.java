package subway.functionList;

import java.util.Arrays;
import java.util.Objects;

public enum RouteFunction implements Function {

    ;
    private String code;
    private String title;
    private Runnable function;

    RouteFunction(String code, String title, Runnable function) {
        this.code = code;
        this.title = title;
        this.function = function;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public Runnable getFunction() {
        return function;
    }

    public static void runNext(String code) {
        Arrays.stream(RouteFunction.values())
            .filter(function -> Objects.equals(function.getCode(), code))
            .findAny()
            .get()
            .getFunction()
            .run();
    }
}
