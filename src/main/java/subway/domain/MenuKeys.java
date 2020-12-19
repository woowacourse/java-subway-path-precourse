package subway.domain;

public enum MenuKeys {
    ONE("1"), TWO("2"), EXIT("Q"), BACK("B");

    private String key;

    MenuKeys(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

}
