package subway.domain.menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.StringJoiner;
import subway.domain.menu.exception.InvalidFunctionKeyException;

public class Menu implements Iterable<MenuItem> {
    private static final String TITLE_FORMAT = "## %s";
    private static final String LINE_BREAK = "\n";

    private String title;
    private final List<MenuItem> menuItems = new ArrayList<>();;

    private Menu(String title) {
        this.title = title;
    }

    public static Menu createWithMenuItems(String title, MenuItem... menuItems) {
        Menu menu = new Menu(title);
        menu.setMenuItems(menuItems);
        return menu;
    }

    private void setMenuItems(MenuItem[] menuItems) {
        this.menuItems.addAll(Arrays.asList(menuItems));
    }

    public void executeMenuItem(String key) {
        MenuItem matchedMenuItem = menuItems.stream()
                .filter(streamMenuItem -> key.equals(streamMenuItem.getKey()))
                .findAny().orElseThrow(InvalidFunctionKeyException::new);

        matchedMenuItem.execute();
    }

    @Override
    public Iterator<MenuItem> iterator() {
        return menuItems.iterator();
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(LINE_BREAK);
        stringJoiner.add(String.format(TITLE_FORMAT, title));
        for (MenuItem menuItem : menuItems) {
            stringJoiner.add(menuItem.toString());
        }

        return stringJoiner.toString();
    }
}
