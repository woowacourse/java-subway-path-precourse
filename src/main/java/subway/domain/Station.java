package subway.domain;

import java.util.function.Supplier;

public class Station {
    private String name;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
