package subway.domain.menu;

public class MenuItem {
    private static final String MENU_ITEM_FORMAT = "%s. %s";

    private String key;
    private String name;
    private Runnable action;

    public MenuItem(String key, String name, Runnable action) {
        this.key = key;
        this.name = name;
        this.action = action;
    }

    public String getKey() {
        return key;
    }

    public void execute() {
        action.run();
    }

    @Override
    public String toString() {
        return String.format(MENU_ITEM_FORMAT, key, name);
    }
}
