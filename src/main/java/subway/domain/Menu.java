package subway.domain;

public class Menu {
    public enum Main {
        ROUTE_INQUIRY,
        QUIT,
    }

    public enum ROUTE_CRITERIA {
        SHORTEST_PATH,
        SHORTEST_TIME,
        BACK,
    }
}
