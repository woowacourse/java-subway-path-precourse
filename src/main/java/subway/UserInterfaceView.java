package subway;

import java.util.Arrays;

public class UserInterfaceView {

    private static final String ONE = "1";
    private static final String TWO = "2";
    private static final String Q = "Q";
    private static final String B = "B";
    private static final String[] MAIN_CHOICE_LIST = {ONE, Q};
    private static final String[] ROUTE_SEARCH_CHOICE_LIST = {ONE, TWO, B};

    public UserInterfaceView() {
    }

    public void start() {
        while (true) {
            if (printMainViewAndReturnIsEnd()) {
                break;
            }
        }
    }

    private boolean printMainViewAndReturnIsEnd() {
        Output.printMainView();
        String userInput = Input.getUserInput();
        if (!Arrays.asList(MAIN_CHOICE_LIST).contains((userInput))) {
            Output.printChoiceErrorMessage();
            return false;
        }
        if (userInput == Q) {
            return true;
        }
        mainToNextFunction(userInput);
        return false;
    }

    private void mainToNextFunction(String userInput) {
        if (ONE.equals(userInput)) {
            //routeSearch();
        }
    }
}
