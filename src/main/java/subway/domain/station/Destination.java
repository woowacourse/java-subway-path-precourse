package subway.domain.station;

public class Destination extends Station {

    public static Station instance = new Destination("종착역");

    public Destination(String name) {
        super(name);
    }

    public static Station getInstance() {
        return instance;
    }
}
