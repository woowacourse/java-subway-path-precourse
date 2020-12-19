package subway.domain;

import java.util.Arrays;
import java.util.function.Function;

public enum Weight {
    TIME("분", Path::getTime),
    DISTANCE("km", Path::getDistance);

    private final String name;
    private final Function<Path, Integer> function;

    Weight(String name, Function<Path, Integer> function) {
        this.name = name;
        this.function = function;
    }

    public static int getWeight(Path path, Weight weight) {
        return Arrays.stream(values())
                .filter(value -> value == weight)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("잘못 입력이 되었습니다."))
                .function.apply(path);
    }
}
