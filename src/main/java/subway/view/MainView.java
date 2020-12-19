package subway.view;

import java.util.Map;
import java.util.Scanner;
import subway.Subway;
import subway.model.MenuGroup.Menu;
import subway.util.Constants;
import subway.util.MessageUtils;

public class MainView {

    private boolean isRunning = true;

    private final Scanner scanner;
    private final Subway subway;

    private Map<String, Runnable> menuActionMap;

    public MainView(Subway subway, Scanner scanner) {
        this.scanner = scanner;
        this.subway = subway;

        initView();
    }

    public void start() {
        isRunning = true;
        while (isRunning) {
            menuSelector();
        }
    }

    public void initView() {
        InquiryView inquiryView = new InquiryView(subway, this.scanner);

        menuActionMap = Map.of(
            "1", inquiryView::start,
            Constants.EXIT_INPUT_CHARACTER, this::goBackward
        );
    }

    private void menuSelector() {
        MessageUtils.printMenu(getMenu());
        String input = scanner.next().toUpperCase();
        MessageUtils.printBlankLine();

        Runnable action = getMenuActionMap().get(input);
        if (action == null) {
            MessageUtils.printError(Constants.INVALID_ASK);
            return;
        }
        action.run();
    }

    public Menu getMenu() {
        return Constants.MENU_GROUPS.get(Constants.MAIN_MENU_STATE);
    }

    public Map<String, Runnable> getMenuActionMap() {
        return menuActionMap;
    }

    public void goBackward() {
        isRunning = false;
    }

}
