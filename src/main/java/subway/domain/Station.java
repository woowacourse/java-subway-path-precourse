package subway.domain;

public class Station {
    private String name;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static boolean isSameStation(String start, String end) {
        if (start.equals(end)) {
            return true;
        }
        return false;
    }
}
