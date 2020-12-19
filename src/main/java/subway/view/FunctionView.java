package subway.view;

import subway.domain.StationManager;

import java.util.Arrays;
import java.util.function.Consumer;

public enum FunctionView {
    DISTANCE("1", "최단 거리", StationManager::byDistance),
    TIME("2", "최소 시간", StationManager::byTime),
    BACK("B", "돌아가기", stationManager -> {});

    private static final String VIEW_FORM = "%s. %s \n";
    private final String key;
    private final String name;
    private final Consumer<StationManager> consumer;

    FunctionView(String key, String name, Consumer<StationManager> consumer) {
        this.key = key;
        this.name = name;
        this.consumer = consumer;
    }

    public static String getViewNames() {
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(values())
                .forEach(value -> stringBuilder.append(String.format(VIEW_FORM, value.key, value.name)));
        return stringBuilder.toString();
    }

    public static FunctionView getFunction(String key) {
        return Arrays.stream(values())
                .filter(value -> value.key.equals(key))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("올바르지 않는 보기를 입력하셨습니다."));
    }

    public void execute(StationManager stationManager){
        consumer.accept(stationManager);
    }
}
