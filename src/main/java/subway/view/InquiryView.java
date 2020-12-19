package subway.view;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import subway.Subway;
import subway.domain.Station;
import subway.model.MenuGroup.Menu;
import subway.util.Constants;
import subway.util.DialogUtils;
import subway.util.MessageUtils;

@SuppressWarnings("checkstyle:Indentation")
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
        String endStationName = DialogUtils.ask(scanner, Constants.INQUIRY_END_STATION_ASK);
        MessageUtils.printAnnouncement(Constants.INQUIRY_RESULT);
        MessageUtils.printInfoEntry(Constants.SEPARATE_STRING_INQUIRY);
        MessageUtils
            .printInfoEntry(Constants.INQUIRY_DISTANCE +
                getShortestDistance(startStationName, endStationName)
                + Constants.INQUIRY_DISTANCE_UNIT);
        List wholePath = getStationsByDistancePath(startStationName, endStationName);
        MessageUtils.printInfoEntry(
            Constants.INQUIRY_TIME +
                getTimeByDistancePath(wholePath) + Constants.INQUIRY_TIME_UNIT);
        MessageUtils.printInfoEntry(Constants.SEPARATE_STRING_INQUIRY);
        wholePath.stream().forEach(name -> MessageUtils.printInfoEntry((String) name));
        MessageUtils.printBlankLine();
    }

    private void showMinimumTime() {
        String startStationName = DialogUtils.ask(scanner, Constants.INQUIRY_START_STATION_ASK);
        String endStationName = DialogUtils.ask(scanner, Constants.INQUIRY_END_STATION_ASK);
        MessageUtils.printAnnouncement(Constants.INQUIRY_RESULT);
        MessageUtils.printInfoEntry(Constants.SEPARATE_STRING_INQUIRY);
        List wholePath = getStationsByTimePath(startStationName, endStationName);
        MessageUtils.printInfoEntry(
            Constants.INQUIRY_DISTANCE +
                getDistanceByTimePath(wholePath) + Constants.INQUIRY_DISTANCE_UNIT);
        MessageUtils
            .printInfoEntry(Constants.INQUIRY_TIME +
                getMinimumTime(startStationName, endStationName) + Constants.INQUIRY_TIME_UNIT);
        MessageUtils.printInfoEntry(Constants.SEPARATE_STRING_INQUIRY);
        wholePath.stream().forEach(name -> MessageUtils.printInfoEntry((String) name));
        MessageUtils.printBlankLine();
    }

    private int getShortestDistance(String startStationName, String endStationName) {
        Station startStation = subway.getStationRepository().findByName(startStationName);
        Station endStation = subway.getStationRepository().findByName(endStationName);
        return subway.getDistancePathRepository().findValue(startStation, endStation);
    }

    private int getTimeByDistancePath(List<String> stations) {
        Iterator stationIter = stations.listIterator();
        Integer cost = 0;
        String previous = (String) stationIter.next();
        while (stationIter.hasNext()) {
            String current = (String) stationIter.next();
            cost += subway.getTimePathRepository()
                .findValue(
                    subway.getStationRepository().findByName((String) previous),
                    subway.getStationRepository().findByName((String) current));
            previous = current;
        }
        return cost;
    }

    private List getStationsByDistancePath(String startStationName, String endStationName) {
        return subway.getDistancePathRepository()
            .findStationToStation(
                subway.getStationRepository().findByName(startStationName),
                subway.getStationRepository().findByName(endStationName));
    }

    private int getMinimumTime(String startStationName, String endStationName) {
        Station startStation = subway.getStationRepository().findByName(startStationName);
        Station endStation = subway.getStationRepository().findByName(endStationName);
        return subway.getTimePathRepository().findValue(startStation, endStation);
    }

    private int getDistanceByTimePath(List<String> stations) {
        Iterator stationIter = stations.listIterator();
        Integer cost = 0;
        String previous = (String) stationIter.next();
        while (stationIter.hasNext()) {
            String current = (String) stationIter.next();
            cost += subway.getDistancePathRepository()
                .findValue(
                    subway.getStationRepository().findByName((String) previous),
                    subway.getStationRepository().findByName((String) current));
            previous = current;
        }
        return cost;
    }

    private List getStationsByTimePath(String startStationName, String endStationName) {
        List stations = subway.getTimePathRepository()
            .findStationToStation(
                subway.getStationRepository().findByName(startStationName),
                subway.getStationRepository().findByName(endStationName));
        return stations;
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
