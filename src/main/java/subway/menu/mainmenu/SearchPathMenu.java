package subway.menu.mainmenu;

import subway.domain.MenuRepository;
import subway.userinterface.ErrorOutput;
import subway.userinterface.Input;

public class SearchPathMenu implements MainMenu{
    public static final String MENU_BUTTON = "1";
    public static final String MENU_NAME = "경로 조회";

    public void run() {
        boolean runStatus = true;
        while(runStatus) {
            Input.printSearchMenu();
            runStatus = runSearchMenu();
        }
    }

    private boolean runSearchMenu() {
        String input = Input.newInput().toUpperCase();
        if (ErrorOutput.isWrongSearchMenuInput(input)) {
            return true;
        }

        for (String key : MenuRepository.searchMenu.keySet()) {
            if (input.equals(key)) {
                MenuRepository.searchMenu.get(key).run();
                return true;
            }
        }
        return false;
    }
}
