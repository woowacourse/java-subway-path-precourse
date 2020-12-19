package subway.functionList;

import java.util.Arrays;
import java.util.Objects;
import subway.controller.MainController;
import subway.controller.RouteController;

public enum MainFunction implements Function {
    MANAGE_ROUTE("1", "경로 조회", RouteController::run),
    QUIT("Q", "종료", MainController::back)
    ;
    private String code;
    private String title;
    private Runnable function;

    MainFunction(String code, String title, Runnable function) {
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
        Arrays.stream(MainFunction.values())
            .filter(function -> Objects.equals(function.getCode(), code))
            .findAny()
            .get()
            .getFunction()
            .run();
    }
}
