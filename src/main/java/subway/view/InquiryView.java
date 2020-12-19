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
        try {
            Map<String, String> station = inputStartAndEndStation(scanner);
            MessageUtils.printAnnouncement(Constants.INQUIRY_RESULT);
            MessageUtils.printInfoEntry(Constants.SEPARATE_STRING_INQUIRY);
            showDistance(getShortestDistance(station.get("start"), station.get("end")));
            List wholePath = getStationsByDistancePath(station.get("start"), station.get("end"));
            showTime(getTimeByDistancePath(wholePath));
            MessageUtils.printInfoEntry(Constants.SEPARATE_STRING_INQUIRY);
            wholePath.stream().forEach(name -> MessageUtils.printInfoEntry((String) name));
            MessageUtils.printBlankLine();
        } catch (Exception e) {
            MessageUtils.printError(e.getMessage());
        }
    }

    private void showMinimumTime() {
        try {
            Map<String, String> station = inputStartAndEndStation(scanner);
            MessageUtils.printAnnouncement(Constants.INQUIRY_RESULT);
            MessageUtils.printInfoEntry(Constants.SEPARATE_STRING_INQUIRY);
            List wholePath = getStationsByTimePath(station.get("start"), station.get("end"));
            showDistance(getDistanceByTimePath(wholePath));
            showTime(getMinimumTime(station.get("start"), station.get("end")));
            MessageUtils.printInfoEntry(Constants.SEPARATE_STRING_INQUIRY);
            wholePath.stream().forEach(name -> MessageUtils.printInfoEntry((String) name));
            MessageUtils.printBlankLine();
        } catch (Exception e) {
            MessageUtils.printError(e.getMessage());
        }
    }

    private void showTime(int time) {
        MessageUtils.printInfoEntry(
            Constants.INQUIRY_TIME + time + Constants.INQUIRY_TIME_UNIT);

    }

    private void showDistance(int distance) {
        MessageUtils.printInfoEntry(
            Constants.INQUIRY_DISTANCE + distance + Constants.INQUIRY_DISTANCE_UNIT);
    }

    private Map<String, String> inputStartAndEndStation(Scanner scanner) {
        String startStationName = getStationNameOrThrow(
            DialogUtils.ask(scanner, Constants.INQUIRY_START_STATION_ASK));
        String endStationName = getStationNameOrThrow(
            DialogUtils.ask(scanner, Constants.INQUIRY_END_STATION_ASK));
        checkDuplicateStationName(startStationName, endStationName);
        return Map.of(
            "start", startStationName,
            "end", endStationName);
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

    private String getStationNameOrThrow(String stationName) {
        Station station = subway.getStationRepository().findByName(stationName);
        if (station == null) {
            throw new RuntimeException(Constants.INVALID_STATION);
        }
        return station.getName();
    }

    private void checkDuplicateStationName(String startName, String endName) {
        if (subway.getStationRepository().findByName(startName)
            .equals(subway.getStationRepository().findByName(endName))) {
            throw new RuntimeException(Constants.INVALID_START_TO_END_STATION);
        }
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
