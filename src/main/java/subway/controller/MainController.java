package subway.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import subway.util.InputUtils;
import subway.util.PrintUtils;

public class MainController implements Controller {

    private final static String TITLE = "메인 화면";
    private final static String QUIT_CODE = "Q";

    private final static HashMap<String, Controller> functionMap = new LinkedHashMap<>();

    public MainController() {
        functionMap.put("1", new ShortestPathController());
        functionMap.put(QUIT_CODE, new QuitController());
    }

    @Override
    public void run(InputUtils inputUtils) {
        while (true) {
            PrintUtils.printMenu(TITLE, functionMap);

            String inputCommand = inputUtils.getNextLine();
            if (InputUtils.checkValidInput(inputCommand, functionMap.keySet())) {
                continue;
            }

            if (inputCommand.equals(QUIT_CODE)) {
                return;
            }

            functionMap.get(inputCommand).run(inputUtils);
        }
    }

    @Override
    public String getTitle() {
        return TITLE;
    }
}
