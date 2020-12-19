package subway.controller;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiConsumer;
import subway.Error;
import subway.Scene;
import subway.domain.PathFinder;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.menu.SectionMenu;
import subway.view.SectionView;
import subway.view.View;

public class SectionViewController extends ViewController {

    public SectionViewController(Scanner scanner, PrintStream printStream) {
        view = new SectionView(scanner, printStream);
    }

    @Override
    public BiConsumer<Scene, View> selectMenu() {
        String input = view.requestMenu();
        BiConsumer<Scene, View> result = SectionMenu.getAction(input);
        if (result == null) {
            view.printError(Error.INVALID_MENU);
        }
        return result;
    }

    public static void findMinDistance(Scene scene, View view) {
        String departureInput = view.requestDepartureStation();
        String arrivalInput = view.requestArrivalStation();
        Error error = isValidStations(departureInput, arrivalInput);
        if (error != Error.OK) {
            view.printError(error);
            return;
        }
        List<String> path = findMinDistancePath(departureInput, arrivalInput, view);
        if (path == null) {
            return;
        }
        view.printPath(path);
        scene.back();
    }

    private static List<String> findMinDistancePath(String departureInput, String arrivalInput,
            View view) {
        Station departureStation = StationRepository.getStationbyName(departureInput);
        Station arrivalStation = StationRepository.getStationbyName(arrivalInput);
        List<String> path = PathFinder.findMinDistancePath(departureStation, arrivalStation);
        if (path == null) {
            view.printError(Error.STATION_NOT_CONNECTED);
        }
        return path;
    }

    public static void findMinTime(Scene scene, View view) {
        String departureInput = view.requestDepartureStation();
        String arrivalInput = view.requestArrivalStation();
        Error error = isValidStations(departureInput, arrivalInput);
        if (error != Error.OK) {
            view.printError(error);
            return;
        }
        List<String> path = findMinTimePath(departureInput, arrivalInput, view);
        if (path == null) {
            return;
        }
        view.printPath(path);
        scene.back();
    }

    private static List<String> findMinTimePath(String departureInput, String arrivalInput,
            View view) {
        Station departureStation = StationRepository.getStationbyName(departureInput);
        Station arrivalStation = StationRepository.getStationbyName(arrivalInput);
        List<String> path = PathFinder.findMinTimePath(departureStation, arrivalStation);
        if (path == null) {
            view.printError(Error.STATION_NOT_CONNECTED);
        }
        return path;
    }

    private static Error isValidStations(String departureInput, String arrivalInput) {
        if (departureInput.equals(arrivalInput)) {
            return Error.SAME_STATIONS;
        }
        Station departureStation = StationRepository.getStationbyName(departureInput);
        Station arrivalStation = StationRepository.getStationbyName(arrivalInput);
        if ((departureStation == null) || (arrivalStation == null)) {
            return Error.STATION_NOT_EXISTS;
        }
        return Error.OK;
    }

    public static void back(Scene scene, View view) {
        scene.back();
    }
}
