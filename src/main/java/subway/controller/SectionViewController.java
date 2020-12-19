package subway.controller;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.function.BiConsumer;
import subway.Error;
import subway.Scene;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.menu.SectionMenu;
import subway.view.SectionView;
import subway.view.View;

public class SectionViewController extends ViewController{

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
        Station departureStation = StationRepository.getStationbyName(departureInput);
        Station arrivalStation = StationRepository.getStationbyName(arrivalInput);
        scene.back();
    }
    
    public static void findMinTime(Scene scene, View view) {
        String departureInput = view.requestDepartureStation();
        String arrivalInput = view.requestArrivalStation();
        Error error = isValidStations(departureInput, arrivalInput);
        if (error != Error.OK) {
            view.printError(error);
            return;
        }
        Station departureStation = StationRepository.getStationbyName(departureInput);
        Station arrivalStation = StationRepository.getStationbyName(arrivalInput);
        scene.back();
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
