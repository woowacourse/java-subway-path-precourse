package subway.controller;

public enum MainButton {
    INQUIRY("1"), EXIT("Q");

    private String symbol;

    MainButton(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
