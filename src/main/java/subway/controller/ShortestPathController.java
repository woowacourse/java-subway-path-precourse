package subway.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import subway.util.InputUtils;
import subway.util.PrintUtils;

public class ShortestPathController implements Controller {

    private final static String TITLE = "경로 조회";
    private final static String IN_TITLE = "경로 기준";
    private final static String BACK_CODE = "B";

    private final static HashMap<String, Controller> functionMap = new LinkedHashMap<>();

    public ShortestPathController() {
        functionMap.put("1", new ShortestDistanceController());
        functionMap.put("2", new ShortestTimeController());
        functionMap.put(BACK_CODE, new BackController());
    }

    @Override
    public void run(InputUtils inputUtils) {
        PrintUtils.printMenu(IN_TITLE, functionMap);

        String inputCommand = inputUtils.getNextLine();
        if (InputUtils.checkValidInput(inputCommand, functionMap.keySet())) {
            return;
        }

        if (inputCommand.equals(BACK_CODE)) {
            return;
        }

        functionMap.get(inputCommand).run(inputUtils);
    }

    @Override
    public String getTitle() {
        return TITLE;
    }
}
