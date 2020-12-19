package subway.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ElapsedTimes {

    private final List<ElapsedTime> times;

    public ElapsedTimes(List<ElapsedTime> times) {
        this.times = times;
    }

    public ElapsedTimes(Integer... times) {
        this.times = Arrays.stream(times)
                .map(ElapsedTime::new)
                .collect(Collectors.toList());
    }

    public List<ElapsedTime> getTimes() {
        return times;
    }
}
