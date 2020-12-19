package subway.view;

import java.util.Map;
import java.util.Scanner;
import subway.Subway;
import subway.domain.Station;
import subway.model.MenuGroup.Menu;
import subway.util.Constants;
import subway.util.DialogUtils;
import subway.util.MessageUtils;

public class InquiryView {

    private boolean isRunning = true;

    private final Scanner scanner;
    private final Subway subway;

    private Map<String, Runnable> menuActionMap;

    public InquiryView(Subway subway, Scanner scanner) {
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

        menuActionMap = Map.of(
            "1", this::showShortestDistance,
            "2", this::showMinimumTime,
            Constants.BACKWARD_INPUT_CHARACTER, this::goBackward
        );
    }

    private void showShortestDistance() {
        String startStationName = DialogUtils.ask(scanner, Constants.INQUIRY_START_STATION_ASK);
        MessageUtils.printInfoEntry(startStationName);
        String endStationName = DialogUtils.ask(scanner, Constants.INQUIRY_END_STATION_ASK);
        MessageUtils.printInfoEntry(endStationName);
        MessageUtils.printAnnouncement(Constants.INQUIRY_RESULT);
//        MessageUtils.printInfo(String.valueOf(getShortestDistance(startStationName, endStationName)));
//        MessageUtils.printInfo(String.valueOf(getShortestTime(startStationName, endStationName)));
    }

    private void showMinimumTime() {
        String startStationName = DialogUtils.ask(scanner, Constants.INQUIRY_START_STATION_ASK);
        MessageUtils.printInfoEntry(startStationName);
        String endStationName = DialogUtils.ask(scanner, Constants.INQUIRY_END_STATION_ASK);
        MessageUtils.printInfoEntry(endStationName);
        MessageUtils.printAnnouncement(Constants.INQUIRY_RESULT);
    }

    private int getShortestTime(String startStationName, String endStationName) {
        Station startStation = subway.getStationRepository().findByName(startStationName);
        Station endStation = subway.getStationRepository().findByName(endStationName);
        return subway.getTimePathRepository().findValue(startStation, endStation);
    }

    private int getShortestDistance(String startStationName, String endStationName) {
        Station startStation = subway.getStationRepository().findByName(startStationName);
        Station endStation = subway.getStationRepository().findByName(endStationName);
        return subway.getDistancePathRepository().findValue(startStation, endStation);
    }

    private int getStationToStationDistance() {
        return 0;
    }

    private int getStationToStationTime() {
        return 0;
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
        return Constants.MENU_GROUPS.get(Constants.INQUIRY_MENU_STATE);
    }

    public Map<String, Runnable> getMenuActionMap() {
        return menuActionMap;
    }

    public void goBackward() {
        isRunning = false;
    }

}
