package subway.view;

import java.util.List;
import java.util.Scanner;

public class MainMenu {

    private static final String TITLE = "## 메인 화면";

    private static final String INQUIRY_SELECTION = "1";
    private static final String QUIT_SELECTION = "Q";


    private static final String INQUIRY_DESCRIPTION = "경로 조회";
    private static final String QUIT_DESCRIPTION = "경로 조회";

    private static final List<String> SELECTIONS = List.of(INQUIRY_SELECTION, QUIT_SELECTION);

    private static final String MENU = TITLE + "\n" + INQUIRY_SELECTION + ". " + INQUIRY_DESCRIPTION + "\n" +
            QUIT_SELECTION + ". " + QUIT_DESCRIPTION;

    private static final String CHOOSE_MESSAGE = "## 원하는 기능을 선택하세요.";

    private static final String NOT_VALID_INPUT_ERROR = "[ERROR] 그 기능은 사용할 수 없습니다.";

    private final Scanner scanner;

    private final GraphMenu graphMenu;

    public MainMenu(Scanner scanner) {
        this.scanner = scanner;
        this.graphMenu = new GraphMenu(scanner);
    }

    public void printMenu() {
        while (true) {
            System.out.println(MENU + "\n" + CHOOSE_MESSAGE);
            String select = scanner.next();

            if (!validInput(select)) {
                System.out.println(NOT_VALID_INPUT_ERROR + "\n");
            } else if (select.equals(QUIT_SELECTION)) {
                break;
            } else if(select.equals(INQUIRY_SELECTION)) {
                graphMenu.printMenu();
            }
        }
    }

    private boolean validInput(String select) {
        if (SELECTIONS.contains(select)) {
            return true;
        }

        return false;
    }


}
