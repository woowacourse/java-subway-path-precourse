package subway.view;

public enum Prefix {
    ERROR("[ERROR] "),
    INFO("[INFO] "),
    SHARP("## "),
    ONE("1. "),
    TWO("2. "),
    QUIT("Q. "),
    BACK("B. "),
    ENTER("\n"),
    CONTOUR("---");

    private String prefix;

    Prefix(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }
}
