package subway.controller;

public enum PathButton {
    SHORTEST_PATH("1"), LEAST_TIME("2"), BACK("B");

    private String symbol;

    PathButton(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
